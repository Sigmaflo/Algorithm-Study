# [11559] Puyo Puyo

import sys
from collections import deque
input = sys.stdin.readline

data = [list(input().rstrip()) for _ in range(12)]

dx = [1,-1,0,0]
dy = [0,0,1,-1]

# 4칸 확인 함수
def BFS(x, y):
    q = deque()
    q.append([x,y])
    puyo.append([x,y])
    while q:
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<=nx<12 and 0<=ny<6 and data[nx][ny] == data[x][y] and visited[nx][ny] == 0:
                q.append([nx,ny])
                tmp.append([nx,ny])
                visited[nx][ny] = 1

# 4칸일 때 지우는 함수
def DELETE(tmp):
    for a, b in tmp:
        data[a][b] = '.'

# 아래로 당기는 함수
def DOWN():

    print()



ans = 0
while 1:
    flag = 0
    visited = [[0]*6 for _ in range(12)]
    for i in range(12):
        for j in range(6):
            if data[i][j] != '.' and visited[i][j] == 0:
                visited[i][j]=1
                tmp = []
                BFS(i, j)
                # 4칸인지 확인
                if len(tmp) >= 4:
                    flag = 1
                    DELETE(tmp)
    
    if flag == 0: #4칸인게 없으면
        break

    DOWN() # 아래로 떨어짐
    ans += 1