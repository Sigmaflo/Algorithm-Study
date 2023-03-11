import sys
sys.stdin = open('트리의 지름.txt', 'r')
input = sys.stdin.readline
n = int(input())
graph = [[] for i in range(n+1)]
for i in range(n):
    temp = list(map(int, input().split()))
    for i in range(1, len(temp) -1, 2):
        graph[temp[0]].append((temp[i], temp[i+1]))

def dfs(start):
    visited = [False] * (n+1)
    dist = [0] * (n+1)
    stack = [start]
    visited[start] = True

    while stack:
        node = stack.pop()
        for v,w in graph[node]:
            if not visited[v]:
                visited[v] = True
                dist[v] = dist[node] + w
                stack.append(v)
    max_node = 1
    max_dist = 0
    for i in range(1, n+1):
        if dist[i] > max_dist:
            max_node = i
            max_dist = dist[i]
    return max_node, max_dist


node1, dist1 = dfs(1)
print(node1, dist1)
node2, dist2 = dfs(node1)
print(node2, dist2)


print(dist2)
        