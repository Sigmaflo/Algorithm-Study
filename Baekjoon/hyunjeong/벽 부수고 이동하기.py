import sys
from collections import deque

sys.stdin = open('벽 부수고 이동하기.txt', 'r')
input = sys.stdin.readline
n, m = map(int, input().split())
grid = []
for i in range(n):
    grid.append(list(input()[:-1]))
print(grid)
stack = deque([])
stack.append((0, 0, 0)) 
grid[0][0] = "1"
wall = 0
print(n, m)
while stack:
    i, j, length = stack.pop()
    print(i, j)
    if i == n-1 and j == m-1:
        print(length+1)
        break
    if i-1 >= 0 and grid[i-1][j] == "0":
        stack.append((i-1, j, length + 1))
        grid[i-1][j] = "1"
    elif i-1 >= 0 and grid[i-1][j] == "1" and wall == 0:
        stack.append((i-1, j, length + 1))
        wall = 1
    if i+1 < n and grid[i+1][j] == "0":
        stack.append((i+1, j, length + 1))
        grid[i+1][j] = "1"
    elif i+1 < n and grid[i+1][j] == "1" and wall == 0:
        stack.append((i+1, j, length + 1))
        wall = 1
    if j-1 >= 0 and grid[i][j-1] == "0":
        stack.append((i, j-1, length + 1))
        grid[i][j-1] = "1"
    elif j-1 >= 0 and (grid[i][j-1] == "1" and wall == 0):
        stack.append((i, j-1, length + 1))
        wall = 1
    if j+1 <= m-1 and grid[i][j+1] == "0":
        stack.append((i, j+1, length + 1))
        grid[i][j+1] = "1"
    elif j+1 <= m-1 and (grid[i][j+1] == "1" and wall == 0):
        stack.append((i, j+1, length + 1))
        wall = 1
    

    


    