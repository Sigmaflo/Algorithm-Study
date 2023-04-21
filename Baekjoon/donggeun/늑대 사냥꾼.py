import sys, heapq
from collections import deque
input = sys.stdin.readline

INF = int(1e9)
dx = [0,1,-1,0]
dy = [1,0,0,-1]

def dist_hut(py:int, px:int) -> int:
    queue = deque()
    queue.append([py,px])
    visited = [[False]*m for _ in range(n)]
    visited[py][px] = True
    while queue:
        y,x = queue.popleft()

        if board[y][x] == "+":
            return abs(py - y) + abs(px - x)
        
        for i in range(4):
            ny,nx = y + dy[i], x + dx[i]
            if ny < 0 or nx < 0 or ny >= n or nx >= m: continue
            if not visited[ny][nx]:
                queue.append([ny,nx])
                visited[ny][nx] = True
    return INF # 사실 여기 올일은 없을 듯

def dijkstra(st_y:int, st_x:int):
    distance = [[INF] * m for _ in range(n)]
    distance[st_y][st_x] = -dist_hut(st_y,st_x)
    hq = []
    heapq.heappush(hq, [distance[st_y][st_x], st_y,st_x]) # 자기가 위치한 곳에서도 오두막 세야하나
    while hq:
        cur,y,x = heapq.heappop(hq)

        if distance[y][x] < cur:
            continue

        for i in range(4):
            ny,nx = y + dy[i], x + dx[i]
            if ny < 0 or nx < 0 or ny >= n or nx >= m: continue

            tmp_dist = -dist_hut(ny,nx)
            if distance[ny][nx] > max(tmp_dist, cur):
                distance[ny][nx] = max(tmp_dist, cur)
                heapq.heappush(hq, [distance[ny][nx], ny, nx])

    print(*distance, sep='\n')
    return -distance[r][c]

n,m = map(int,input().split())
board = [list(map(str,input().rstrip())) for _ in range(n)]
r,c = -1,-1
st_y, st_x = -1,-1
# dist = [[0]*m for _ in range(n)]

for i in range(n):
    for j in range(m):
        # dist[i][j] = -dist_hut(i,j)
        if board[i][j] == "V":
            st_y,st_x = i,j
        elif board[i][j] == "J":
            r,c = i,j

print(dijkstra(st_y,st_x))