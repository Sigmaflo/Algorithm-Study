import sys


sys.stdin = open('인내의 도미노 장인 호석.txt', 'r')

n, m, r = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

is_offense = True
directions = {'E': (0, 1), 'W': (0, -1), 'S': (1, 0), 'N': (-1, 0)}
play = [x[:] for x in grid]
score = 0
for _ in range(r*2):
    if is_offense:
        x, y, d = input().split()
        x, y = int(x), int(y)

        cur_x, cur_y = x, y
        dx, dy = directions[d]
        count = play[x][y]
        while 0<=cur_x<n and 0<=cur_y<m and count > 0:
            score += 1
            count -= 1
            play[cur_x][cur_y] = 0
            cur_x = x + dx
            cur_y = y + dy
        while 0<=cur_x<n and 0<=cur_y<m and play[cur_x][cur_y]:
            score += 1
            play[cur_x][cur_y] = 0
            cur_x = x + dx
            cur_y = y + dy
        is_offense = False
    else:
        x, y = map(int, input().split())
        play[x][y] = grid[x][y]
        is_offense = True
print(score)
res = []
for i in range(n):
    for j in range(m):
        if play[i][j]:
            res.append('F')
        else:
            res.append('S')


