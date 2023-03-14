from collections import deque
import sys, heapq
input = sys.stdin.readline

def find(parent, x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x])
    return parent[x]

def union(parent, a, b):
    a = find(parent, a)
    b = find(parent, b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b

n,m = map(int,input().split())
s,e = map(int,input().split())
parent = [i for i in range(n+1)]
hq = []
graph = [[] for _ in range(n+1)]
ans = int(1e9)
for _ in range(m):
    u,v,w = map(int,input().split())
    heapq.heappush(hq, [-w, u, v])

while hq:
    w,u,v = heapq.heappop(hq)
    # w = -w
    if find(parent, u) != find(parent, v):
        union(parent, u, v)

        ans = min(ans, -w)

    if find(parent, s) == find(parent, e):
        print(ans)
        break
else:
    print(0)