# [1325] 효율적인 해킹 (실버 1)
import sys
input = sys.stdin.readline
from collections import deque
N, M = map(int, input().split())
graph = [[] for _ in range(N+1)]
for i in range(M):
    a, b = map(int, input().split())
    graph[b].append(a)

def FIND(start):
    cnt = 0
    q = deque()
    visited = [False for _ in range(N+1)]
    q.append(start)
    visited[start] = True
    while q:
        idx = q.popleft()
        for i in graph[idx]:
            if not visited[i]:
                visited[i] = True
                cnt += 1
                q.append(i)
    return cnt

max_cnt = 0
ans = []
for i in range(1, N+1):
    if len(graph[i]) > 0:
        cnt = FIND(i)
        if cnt > max_cnt:
            max_cnt = cnt
            ans.clear()
            ans.append(i)
        elif cnt == max_cnt:
            ans.append(i)

print(*ans)