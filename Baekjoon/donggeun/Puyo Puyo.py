from collections import deque
import sys
input = sys.stdin.readline

dx = [0,-1,1,0]
dy = [1,0,0,-1]

def gravity(): # 중력 반응, 블럭 아래로 내리기
    for j in range(m):
        tmp = []
        for i in range(n):
            if board[n-i-1][j] != ".":
                tmp.append(board[n-i-1][j])
        
        for i in range(len(tmp)):
            board[n-i-1][j] = tmp[i]
        for i in range(len(tmp), n):
            board[n-i-1][j] = "."

def bfs(py:int, px:int): # 연쇄 반응 확인
    queue = deque()
    queue.append([py,px])
    visited[py][px] = True
    candi = [[py,px]]
    while queue:
        y,x = queue.popleft()

        for i in range(4):
            ny,nx = y + dy[i], x + dx[i]

            if ny < 0 or nx < 0 or ny >= n or nx >= m:
                continue
            elif board[ny][nx] != board[py][px]:
                continue
            elif visited[ny][nx]:
                continue
            candi.append([ny, nx])
            visited[ny][nx] = True
            queue.append([ny, nx])
    
    # 터뜨리기
    if len(candi) >= 4:
        global chain
        chain += 1
        for ny, nx in candi:
            board[ny][nx] = "."
    return

n,m = 12, 6
board = [list(map(str,input().rstrip())) for _ in range(n)]
ans = 0

while True:
    visited = [[False]*m for _ in range(n)]
    chain = 0
    for i in range(n):
        for j in range(m):
            if board[i][j] != "." and not visited[i][j]:
                bfs(i,j)
    gravity()
    if not chain:
        break
    ans += 1
print(ans)