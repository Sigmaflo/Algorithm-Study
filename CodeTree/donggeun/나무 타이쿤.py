from collections import deque

# → ↗ ↑ ↖ ← ↙ ↓ ↘
dxs = [0, -1, -1, -1, 0, 1, 1, 1] 
dys = [1, 1, 0, -1, -1, -1, 0, 1]

n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
d, p = 0, 0

queue = deque()  # 특수영양제 초기 위치
queue.append((n - 2, 0))
queue.append((n - 2, 1))
queue.append((n - 1, 0))
queue.append((n - 1, 1))
nxt_queue = deque() # d

def in_range(x, y):
    return 0 <= x < n and 0 <= y < n

def nutrients_move():
    while queue:
        x, y = queue.popleft()
        nx, ny = x + dxs[d] * p, y + dys[d] * p
        if in_range(nx, ny):
            x, y = nx, ny
        else:
            x = (x + dxs[d] * p + n * p) % n
            y = (y + dys[d] * p + n * p) % n
        nxt_queue.append((x, y))

def around_num(x, y):
    dxs, dys = [-1, -1, 1, 1], [-1, 1, 1, -1]
    cnt = 0
    for dx, dy in zip(dxs, dys):
        nx, ny = x + dx, y + dy
        if in_range(nx, ny) and arr[nx][ny] > 0:
            cnt += 1
    return cnt

def nutrients_push():
    while nxt_queue:
        x, y = nxt_queue.popleft()
        arr[x][y] += 1  # 2
        arr[x][y] += around_num(x, y)  # 3
        visited[x][y] = True

def nutrients_refresh():
    for i in range(n):
        for j in range(n):
            if not visited[i][j]:
                if arr[i][j] >= 2:
                    arr[i][j] -= 2
                    queue.append((i, j))  # 특수 영양제 투입
                    visited[i][j] = True

def simulate():
    nutrients_move()
    nutrients_push()
    nutrients_refresh()

for _ in range(m):
    d, p = map(int, input().split())  # 방향, 이동칸 수
    d -= 1
    visited = [[False]*n for _ in range(n)]
    simulate()

print(sum(map(sum,arr)))
