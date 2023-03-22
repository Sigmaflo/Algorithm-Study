V, E = map(int, input().split())
graph = [[] for _ in range(V+1)]
for _ in range(E):
a, b = map(int, input().split())
graph[a].append(b)
graph[b].append(a)
degrees = [len(graph[i]) for i in range(V+1)]
visited = [False] * (V+1)
stack = [1]
visited[1] = True
while stack:
    node = stack.pop()
    for adj_node in graph[node]:
        if not visited[adj_node]:
            visited[adj_node] = True
            stack.append(adj_node)
        if False in visited:
            print("NO")
            break
odd_count = 0
for degree in degrees:
    if degree % 2 != 0:
        odd_count += 1
    if odd_count == 0 or odd_count == 2:
        print("YES")
    else:
        print("NO")