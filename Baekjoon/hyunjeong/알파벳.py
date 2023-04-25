import copy
import sys


# sys.stdin = open('알파벳.txt', 'r')
input = sys.stdin.readline

r, c = map(int, input().split())
board = []

for _ in range(r):
    temp = input().strip()
    board.append(temp)

# start from (0, 0)
stack = set([(0, 0, board[0][0])])
res = 1

while stack:
    x, y, visited = stack.pop()

    # update res
    if len(visited) > res:
        res = len(visited)

    # check bottom, top, right, left
    for i in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
        tempx = x+i[0]
        tempy = y+i[1]
        # check in-bounds and duplicates
        if 0<=tempx<r and 0<=tempy<c and board[tempx][tempy] not in visited:
            stack.add((tempx, tempy, visited+board[tempx][tempy]))

print(res)