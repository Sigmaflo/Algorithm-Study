# [2206] 벽 부수고 이동하기 (골드 3)
import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
input_list = [[0]*M for _ in range(N)]


for i in range(N):
    tmp = str(input())
    for j in range(M):
        input_list[i][j] = int(tmp[j])

# 벽 부수기: 1번만 가능
dx = [0,0,1,-1]
dy = [1,-1,0,0]
# visited[N][M][2] # 벽 부수고 온건지 확인
visited = [[[0]*2 for _ in range(M)] for _ in range(N)]

# for i in range(N):
#     print(visited[i])

answer = 0
flag = 0 # 0: 부술 수 있음 # 1: 못부숨
def BFS():
    global answer
    global flag
    q = deque()
    q.append([0, 0, flag])
    visited[0][0][0] = 1
    visited[0][0][1] = 1
    while q:
        x, y, flag = q.popleft()
        # 목적지 도착 시 종료
        if x==N-1 and y==M-1:
            if visited[x][y][0] != 0 and visited[x][y][1] != 0:
                answer = min(visited[x][y][0], visited[x][y][1])
            else:
                answer = visited[x][y][flag]
            return answer
        for i in range(4):
            nx = dx[i]+x
            ny = dy[i]+y
            if 0<=nx<N and 0<=ny<M:
                # 1인 경우+flag 0이면 벽 부수고 이동 가능
                if input_list[nx][ny] == 1 and flag == 0 and visited[nx][ny][flag+1] == 0:
                    visited[nx][ny][flag+1]=visited[x][y][flag]+1
                    q.append([nx, ny, flag+1])
                elif input_list[nx][ny] == 0 and visited[nx][ny][flag] == 0:
                    visited[nx][ny][flag] = visited[x][y][flag]+1
                    q.append([nx,ny,flag])
                else: # input_list == 1 & flag == 1
                    continue
    
    return -1


print(BFS())