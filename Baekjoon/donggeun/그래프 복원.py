import sys, heapq

sys.stdin = open("input.txt", "r")
input = sys.stdin.readline
INF = int(1e9)

n,m = map(int,input().split())
graph = [[INF]*n for _ in range(n)]
for x in range(n):
    graph[x][x] = 0

edges = []
direct = [[False]*n for _ in range(n)]

for i in range(n-1):
    dist = list(map(int,input().split()))
    for j in range(i+1, i+len(dist)+1):
        # 2차원 배열 설정
        graph[i][j] = dist[j-i-1]
        graph[j][i] = dist[j-i-1]
        heapq.heappush(edges, [dist[j-i-1], i, j])

board = [[INF]*n for _ in range(n)]
for x in range(n):
    board[x][x] = 0

ans = []
cnt = 0
while edges:
    c, a, b = heapq.heappop(edges)
    if c < board[a][b]:
        board[a][b] = c
        board[b][a] = c
        ans.append((a,b,c))
        # 바뀐 경로 저장
        for x in range(n):
            for i in range(n):
                for j in range(n):
                    if i == j:
                        continue
                    if board[i][j] > board[i][x] + board[x][j]:
                        board[i][j] = board[i][x] + board[x][j]
                        board[j][i] = board[i][x] + board[x][j]
    print("board")
    print(*board, sep='\n')
    if cnt == m:
        break

def solve():
    for i in range(n):
        for j in range(n):
            if board[i][j] != graph[i][j]:
                print(0)
                return
    print(1)
    ans.sort()
    for a,b,c in ans:
        print(a+1, b+1, c)
    return

solve()