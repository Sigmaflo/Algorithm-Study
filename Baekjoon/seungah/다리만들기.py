# [2146] 다리 만들기 (골드 3)
import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
islands = [list(map(int, input().split())) for _ in range(N)]

dx = [0,0,-1,1]
dy = [1,-1,0,0]

def indexing_island(x, y):
    q = deque()
    q.append([x, y])
    while q:
        x, y = q.popleft()
        islands[x][y] = idx
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0<=nx<N and 0<=ny<N and islands[nx][ny] == 1 and not visited[nx][ny]:
                visited[nx][ny] = True
                q.append([nx, ny])

def find_island(i, j, cnt):
    q=deque()
    first_val = islands[i][j]
    q.append([i, j, cnt])
    while q:
        x, y, cnt = q.popleft()
        check[x][y] = 1
        for i in range(4):
            nx = dx[i]+x
            ny = dy[i]+y
            # 다른 섬 도착 시
            if 0<=nx<N and 0<=ny<N and check[nx][ny] == 0 and islands[nx][ny] != first_val:
                check[nx][ny] = 1
                if islands[nx][ny] < 0:
                    return cnt
                else:
                    q.append([nx, ny, cnt+1])

    return 1e9


idx = -1
visited = [[False]*N for _ in range(N)]
for i in range(N):
    for j in range(N):
        if islands[i][j] == 1 and not visited[i][j]:
            indexing_island(i, j)
            idx -= 1

answer = 1e9
for i in range(N):
    for j in range(N):
        if islands[i][j] < 0:
            check = [[0]*N for _ in range(N)]
            answer = min(answer, find_island(i, j, 0))

print(answer)