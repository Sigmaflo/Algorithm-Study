n, m = map(int, input().split())

a = [list(map(int, input().split())) for _ in range(n)]
moves = [list(map(int, input().split())) for _ in range(m)]

a = [[0]*n for _ in range(n)]
c = [[False]*n for _ in range(n)]
for i in range(n):
    row = list(map(int, input().split()))
    for j in range(n):
        a[i][j] = row[j]

moves = [[0, 0]] + moves
clouds = [(n-1, 0), (n-1, 1), (n-2, 0), (n-2, 1)]
for move in moves[1:]:
    dx, dy = move[0], move[1]
    new_clouds = []
    for cloud in clouds:
        x, y = cloud[0], cloud[1]
        nx, ny = (x+dx)%n, (y+dy)%n
        new_clouds.append((nx, ny))
        c[x][y], c[nx][ny] = False, True

    for cloud in new_clouds:
        x, y = cloud[0], cloud[1]
        a[x][y] += 1
        c[x][y] = True

