# 주사위를 갖고 있으니 각각의 경우
# 전부 bfs 사용해서 탐색해야 할듯

from collections import deque
import sys
input = sys.stdin.readline

dy = (0,1,-1,0)
dx = (1,0,0,-1)

def bfs(r:int, c:int) -> int:
    queue = deque()
    queue.append((r,c))
    visited[r][c] = True
    while queue:
        y,x = queue.popleft()

        for i in range(4):
            ny,nx = dy[i]+y, dx[i]+x
            if ny < 0 or nx < 0 or ny >= n or nx >= m: continue

            

n,m,k = map(int,input().split())
board = [list(map(int,input().split())) for _ in range(n)]
visited = [[False]*m for _ in range(n)]


print("출근하기싫다")