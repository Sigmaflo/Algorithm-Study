from collections import deque
import sys
input = sys.stdin.readline

dy = [0,-1,0,1]
dx = [-1,0,1,0]

def out_of_range(ny:int, nx:int) -> bool:
    return ny < 0 or nx < 0 or ny >= n or nx >= m

def bfs(r:int, c:int, idx:int) -> None:
    queue = deque()
    queue.append((r,c)) # y,x,cnt
    visited[r][c] = idx
    cnt = 0
    while queue:
        y,x = queue.popleft()
        cnt += 1
        for i in range(3, -1, -1):
            ny,nx = dy[i]+y, dx[i]+x
            if out_of_range(ny,nx):
                # if board[y][x] >> i == 1:
                board[y][x] -= 1<<i # 밖으로 나가는건 무조건 1일듯?
                continue

            if board[y][x] >> i == 1: # 벽이라는 의미
                board[y][x] -= 1<<i
            elif not visited[ny][nx]:
                queue.append((ny,nx))
                visited[ny][nx] = idx
    room[idx] = cnt


m,n = map(int,input().split())
board = [list(map(int,input().split())) for _ in range(n)]
visited = [[0]*m for _ in range(n)]
room = dict()

idx = 0
for r in range(n):
    for c in range(m):
        if not visited[r][c]:
            idx += 1
            bfs(r,c,idx)


ans = []
for y in range(n):
    for x in range(m):
        if x != m-1:
            if visited[y][x] != visited[y][x+1]:
                 ans.append(room[visited[y][x]] + room[visited[y][x+1]])
        if y != n-1:
            if visited[y][x] != visited[y+1][x]:
                ans.append(room[visited[y][x]] + room[visited[y+1][x]])
print(len(room), max(room.values()),max(ans), sep='\n')