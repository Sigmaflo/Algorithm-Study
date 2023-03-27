from collections import deque

field = [list(input()) for _ in range(12)]

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def pop_puyos(puyos, visited, x, y, color):
    q = deque()
    q.append((x, y))
    visited[x][y] = True
    puyos.append((x, y))
    
    while q:
        cur_x, cur_y = q.popleft()
        for i in range(4):
            nx, ny = cur_x + dx[i], cur_y + dy[i]
            if 0 <= nx < 12 and 0 <= ny < 6 and not visited[nx][ny] and field[nx][ny] == color:
                visited[nx][ny] = True
                q.append((nx, ny))
                puyos.append((nx, ny))
                
