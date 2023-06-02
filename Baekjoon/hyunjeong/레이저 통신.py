from collections import deque
import sys


sys.stdin = open('레이저 통신.txt', 'r')
input = sys.stdin.readline

w, h = map(int, input().split())
grid = []
for _ in range(h):
    grid.append([*input().strip()])

start, end = -1, -1
for i in range(h):
    for j in range(w):
        if grid[i][j] == 'C':
            if start == -1:
                start = (i, j)
            else:
                end = (i, j)

d = deque([])
d.append((*start, 0, 'PASS'))

visited = [[1e9]*w for _ in range(h)]
visited[start[0]][start[1]] = 0
answer = 1e9

def in_bounds(x, y):
    return 0<=x<h and 0<=y<w

def is_passable(x, y):
    return grid[x][y] != '*'   

def reached_end(x, y):
    return (x, y) == end

while d:
    x, y, changes, dir = d.popleft()

    print(x, y, changes, dir)
    # if (x, y) == end:
    #     print(x, y, changes, dir)
    #     answer = min(answer, changes)


    for dx, dy, new_dir in zip([-1, 1, 0, 0], [0, 0, -1, 1], ['N', 'S', 'W', 'E']):
        new_x = x+dx
        new_y = y+dy
        if in_bounds(new_x, new_y):
            if reached_end(new_x, new_y):
                if dir == 'PASS' or dir == new_dir:
                    answer = min(answer, changes)
                else:
                    answer = min(answer, changes+1)
            if is_passable(new_x, new_y) and visited[new_x][new_y] >= visited[x][y]:
                if dir == 'PASS' or dir == new_dir:
                    d.append((new_x, new_y, changes, new_dir))
                    print('added', (new_x, new_y, changes, new_dir))
                else:
                    d.append((new_x, new_y, changes+1, new_dir))
                    print('added', (new_x, new_y, changes+1, new_dir))
                visited[new_x][new_y] = visited[x][y] + 1

print(answer)
    




