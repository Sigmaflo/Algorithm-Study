# [1600] 말이 되고픈 원숭이
from collections import deque
K = int(input())
W, H = map(int, input().split())

kx = [2, 1, -1, -1, 2, 1, -2, -2]
ky = [1, 2, 2, -2, -1, -2, -1, 1]

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

zoo = []
visited = [[[0]*(K+1) for _ in range(W)] for _ in range(H)]
# for i in range(H):
#     print(visited[i])

for i in range(H):
    tmp = list(map(int, input().split()))
    tmp = [-1 if i==1 else i for i in tmp]
    zoo.append(tmp)

# for i in range(H):
#     print(zoo[i])
answer = 1e9
def BFS():
    global answer
    q = deque()
    q.append([0,0,0]) # (시작 인덱스), 0(k사용횟수)
    visited[0][0][0] = 1

    while q:
        x, y, k = q.popleft()
        ## 목적지 확인
        if x == H-1 and y == W-1:
            for i in range(K+1):
                if visited[x][y][i] != 0:
                    answer = min(answer, visited[x][y][i])
            return answer-1

        if k < K:
            for i in range(8):
                nx = kx[i] + x
                ny = ky[i] + y
                if 0 <= nx < H and 0 <= ny < W and zoo[nx][ny] == 0:
                    if visited[nx][ny][k+1] == 0:
                        visited[nx][ny][k+1] = visited[x][y][k]+1
                        q.append([nx,ny,k+1])
                        
        
        for i in range(4):
            nx = dx[i]+x
            ny = dy[i]+y
            if 0 <= nx < H and 0 <= ny < W and zoo[nx][ny] == 0:
                if visited[nx][ny][k] == 0:
                    q.append([nx, ny, k])
                    visited[nx][ny][k] = visited[x][y][k]+1
    
    return -1


print(BFS())