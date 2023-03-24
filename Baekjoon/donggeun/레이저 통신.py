from collections import deque
import sys
input = sys.stdin.readline

dx = [0,0,-1,1]
dy = [-1,1,0,0]

def bfs(a,b):
    queue = deque()
    queue.append([a,b,0,0])
    queue.append([a,b,1,0])

    visited = [[[-1]*(w) for _ in range(h)] for _ in range(2)]
    visited[0][a][b] = 0
    visited[1][a][b] = 0
    while queue:
        y,x,z,cnt = queue.popleft()
        if y != a and x != b and board[y][x] == "C":
            return cnt
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= w or ny >= h:
                continue
            if board[ny][nx] == "*":
                continue
            if visited[z][ny][nx] != -1:
                continue
            if i == 0 or i == 1: # y값 변환
                if z == 0: # 똑같이 y값 변환되어 오고 있었음
                    visited[z][ny][nx] = cnt
                    queue.append([ny,nx,z,cnt])
                else: # 온건 x값 변환되어 오고 있었음
                    visited[z-1][ny][nx] = cnt + 1
                    queue.append([ny,nx,z-1,cnt+1])
            else:
                if z == 0:
                    visited[z+1][ny][nx] = cnt + 1
                    queue.append([ny,nx,z+1,cnt+1])
                else:
                    visited[z][ny][nx] = cnt
                    queue.append([ny,nx,z,cnt])

w,h = map(int,input().split())
board = [list(map(str,input().rstrip())) for _ in range(h)]

for y in range(h):
    for x in range(w):
        if board[y][x] == "C":
            print(bfs(y,x))
            break