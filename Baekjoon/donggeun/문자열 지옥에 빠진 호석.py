from collections import defaultdict
import sys
input = sys.stdin.readline

dx = [0, 1, -1, 0, 1, 1, -1, -1]
dy = [1, 0, 0, -1, 1, -1, 1, -1]

def dfs(y,x, cnt, string):
    if cnt > 4:
        return
    love[string] += 1
    for i in range(8):
        nx = (dx[i] + x) % m
        ny = (dy[i] + y) % n

        dfs(ny, nx, cnt+1, string+board[ny][nx])

n,m,k = map(int,input().split())
board = [list(map(str,input().rstrip())) for _ in range(n)]
love = defaultdict(int)

for i in range(n):
    for j in range(m):
        dfs(i,j,0,board[i][j])

for _ in range(k):
    candi = dict()
    word = input().rstrip()
    print(love[word])