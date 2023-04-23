from collections import deque
import sys


def bfs(n, m, g, new_walls):
    print('BEFORE')
    print(new_walls)
    print(g)
    queue = deque([])
    visited = set([])
    for x in range(n):
        for y in range(m):
            if (x, y) in set(new_walls):
                g[x][y] = 1
            elif g[x][y] == 2:
                queue.append((x, y))
                visited.add((x, y))

    while queue:
        x, y = queue.popleft()
        for k in [(0, -1), (0, 1), (-1, 0), (1, 0)]:
            tempx = x+k[0]
            tempy = y+k[1]
            if 0<=tempx<n and 0<=tempy<m and g[tempx][tempy] == 0 and (tempx, tempy) not in visited:
                queue.append((tempx, tempy))
                visited.add((tempx, tempy))
                g[tempx][tempy] = 2
    print('AFTER')
    print(g)
    count = count_safe_places(n, m, g)
    # print(count)
    return count

    
def count_safe_places(n, m, g):
    count = 0
    # print(g)
    for i in range(n):
        for j in range(m):
            if g[i][j] == 0:
                count += 1
    return count

sys.stdin = open('연구소.txt', 'r')
input = sys.stdin.readline

n, m = map(int, input().split())
limit = 3
graph = []
vlocs = []
for i in range(n):
    temp = list(map(int, input().split()))
    graph.append(temp)

res = 1e9
new_walls = deque([])
for i in range(n):
    for j in range(m):
        if graph[i][j] == 0 and len(new_walls) < 3:
            new_walls.append((i, j))
        elif graph[i][j] == 0 and len(new_walls) >= 3:
            g = [x[:] for x in graph]
            print(g)
            res = min(res, bfs(n, m, g, new_walls))
            new_walls.popleft()
            new_walls.append((i, j))

    
print(graph)    
print(res)