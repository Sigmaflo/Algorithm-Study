import sys


def dfs(g, x, y, height):
    stack = [(x, y)]
    visited = set([(x, y)])

    while stack:
        curx, cury = stack.pop()
        g[curx][cury] = -1
        for i in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
            newx = curx + i[0]
            newy = cury + i[1]
            if newx >= 0 and newx < len(g) and newy >= 0 and newy < len(g[newx]) and g[newx][newy] > height:
                stack.append((newx, newy))
                visited.add((newx, newy))
    return g


sys.stdin = open('안전 영역.txt', 'r')
input = sys.stdin.readline

n = int(input())

graph = []
max_height = 0
for _ in range(n):
    temp = list(map(int, input().split()))
    max_height = max(max(temp), 0)
    graph.append(temp)

res = 1
for height in range(1, max_height):

    g = [x[:] for x in graph] 
    count = 0
    for i in range(n):
        for j in range(n):
            if g[i][j] > height:
                g = dfs(g, i, j, height)
                count += 1
    res = max(count, res)
print(res)
