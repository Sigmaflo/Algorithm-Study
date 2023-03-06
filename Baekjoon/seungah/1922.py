# [1922] 네트워크 연결

import sys
input = sys.stdin.readline

## 모든 컴퓨터 연결 시 필요한 최소 비용 출력

N = int(input()) # 컴퓨터 수
M = int(input()) # 연결할 수 있는 선의 수

# M개의 줄에 각 컴퓨터를 연결하는데 드는 비용 주어짐
## 크루스칼 알고리즘 사용

def find_parent(x):
    if parent[x] != x:
        parent[x] = find_parent(parent[x])
    return parent[x]

def union_parent(a, b):
    a = find_parent(a)
    b = find_parent(b)
    if a<b:
        parent[b] = a
    else:
        parent[a] = b

edges = []
answer = 0
parent = [ i for i in range(N+1)]

for _ in range(M):
    a, b, cost = map(int, input().split())
    edges.append((cost, a, b))

edges.sort()

for edge in edges:
    cost, a, b = edge

    if find_parent(a) != find_parent(b):
        union_parent(a, b)
        answer += cost

print(answer)