from collections import deque
import sys, copy
input = sys.stdin.readline

dx = (1,0,-1,0)
dy = (0,1,0,-1)

def solve():
    year = 0
    melted = [[0]*m for _ in range(n)]
    global board

    while True:
        visited = [[False]*m for _ in range(n)]
        flag = False

        for r in range(n):
            for c in range(m):
                if not visited[r][c] and board[r][c]:
                    if flag: # 이전에 한번 bfs 탐색 했음
                        return year
                    else:
                        bfs(r,c,visited, melted)
                        flag = True

        board = copy.deepcopy(melted)
        year += 1

        if sum(map(sum, visited)) == 0:
            return 0

def bfs(r:int, c:int, visited: list[list[bool]], melted: list[list[int]]) -> None:
    queue = deque()
    queue.append((r,c))
    visited[r][c] = True

    while queue:
        y,x = queue.popleft()
        water = 0

        for i in range(4):
            ny,nx = dy[i]+y, dx[i]+x

            if ny < 0 or nx < 0 or ny >= n or nx >= m:
                continue
            
            if board[ny][nx] == 0:
                water += 1

            if not visited[ny][nx] and board[ny][nx]: # 방문안했고, 빙판이라면
                queue.append((ny,nx))
                visited[ny][nx] = True

        melted[y][x] = max(board[y][x] - water, 0)

n,m = map(int,input().split())
board = [list(map(int,input().split())) for _ in range(n)]

# 안부서지는 거 생각해야함
print(solve())

