import sys


def bfs(n, m, graph, i, j, visited):
    stack = [(i, j)]
    while stack:
        i, j = stack.pop()
        for k in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
            new_i = i+k[0]
            new_j = j+k[1]
            if 0<=new_i<n and 0<=new_j<m and graph[new_i][new_j] > 0 and (new_i, new_j) not in visited:
                stack.append((new_i, new_j))
                visited.add((new_i, new_j))
    
def count_icebergs(n, m, graph):
    num_icebergs = 0
    visited = set([])
    for i in range(n):
        for j in range(m):
            if graph[i][j] > 0 and (i, j) not in visited:
                visited.add((i, j))
                bfs(n, m, graph, i, j, visited)
                num_icebergs += 1
    return num_icebergs

# sys.stdin = open('빙산.txt', 'r')
input = sys.stdin.readline

n, m = map(int, input().split())
graph = []
for _ in range(n):
    graph.append(list(map(int, input().split())))

year = 0
while True:

    num_icebergs = count_icebergs(n, m, graph)
    if num_icebergs >= 2:
        break 
    if num_icebergs == 0:
        year = 0
        break

    new_graph = [[0 for _ in range(m)] for _ in range(n)]
    for i in range(n):
        for j in range(m):
            # if graph[i][j] hasn't melted, update height
            if graph[i][j] > 0:
                water_count = 0
                for k in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
                    new_i = i+k[0]
                    new_j = j+k[1]
                    if 0<=new_i<n and 0<=new_j<m and graph[new_i][new_j] == 0:
                        water_count += 1

                # if updated height > 0, update new_graph with new height
                if graph[i][j] - water_count > 0:
                    new_graph[i][j] = graph[i][j] - water_count
                # else do nothing because new_graph is initialized with zeros

                # new_graph[i][j] = max(0, graph[i][j]-water_count) performs the same thing as the code above
    
    # update graph with new_graph
    graph = [x[:] for x in new_graph]
    # update year by 1
    year += 1

print(year)
                



