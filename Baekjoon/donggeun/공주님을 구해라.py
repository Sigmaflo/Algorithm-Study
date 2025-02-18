from collections import deque
import sys
input = sys.stdin.readline

dx = [1,0,-1,0]
dy = [0,1,0,-1]

def bfs(a,b):
    queue = deque()
    queue.append([a,b,0,False]) # x,y,시간,그람 습득여부
    visited = [[False]*(m) for _ in range(n)]
    gram_visited = [[False]*(m) for _ in range(n)]
    visited[a][b] = True
    while queue:
        x,y,time,gram = queue.popleft()
        if time > t:
            return 'Fail'
        if x == n-1 and y == m-1:
            return time
        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]

            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue
            
            if gram:
                if not gram_visited[nx][ny]:
                    queue.append([nx,ny,time+1,True])
                    visited[nx][ny] = True
                    gram_visited[nx][ny] = True
                    continue

            if not visited[nx][ny]: # 방문안했다면
                if graph[nx][ny] == 2:
                    queue.append([nx,ny,time+1,True])
                    visited[nx][ny] = True
                elif graph[nx][ny] == 1:
                    continue
                elif graph[nx][ny] == 0:
                    queue.append([nx,ny,time+1,gram])
                    visited[nx][ny] = True
    return 'Fail'

n,m,t = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(n)]

print(bfs(0,0))