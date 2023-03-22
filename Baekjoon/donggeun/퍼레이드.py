from collections import deque
import sys
input = sys.stdin.readline

def bfs(st):
    visited = [0]*(v+1)
    visited[st] = 1
    queue = deque()
    queue.append(st)
    while queue:
        node = queue.popleft()

        for x in graph[node]:
            if not visited[x]:
                queue.append(x)
                visited[x] = 1
    
    return sum(visited) == v

v,e = map(int,input().split())
graph = [[] for _ in range(v+1)]

for i in range(e):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

odd = 0
for x in graph:
    if len(x) % 2 != 0:
        odd += 1
print("YES" if (not odd or odd == 2) and bfs(1) else "NO")
