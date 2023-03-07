N, M = map(int, input().split())
graph = [[] for x in range(N)]

for i in range(M):
    a, b = map(int, input().split())
    graph[a-1].append((b-1, 1))
    graph[b-1].append((a-1, 1))