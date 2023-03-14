from collections import deque
import sys
input = sys.stdin.readline

dx = [0,1,-1,0,1,1,-1,-1]
dy = [1,0,0,-1,1,-1,1,-1]

def bfs(py,px,st):
    queue = deque()
    queue.append([py,px,st])

    while queue:
        y,x,w = queue.popleft()
        for i in range(8):
            nx = (x + dx[i])%m
            ny = (y + dy[i])%n
            # 신이 좋아하는 문자열 될 가능성 있음
            if w+board[ny][nx] in pre_fix:
                if w+board[ny][nx] not in love:
                    queue.append([ny,nx,w+board[ny][nx]])
            # 신이 좋아하는 문자열이면서 또 다른 신이 좋아하는 문자열이 될 가능성이 있음
                elif w+board[ny][nx] in love:
                    queue.append([ny,nx,w+board[ny][nx]])
                    love[w+board[ny][nx]] += 1
        

n,m,k = map(int,input().split())
board = [list(map(str,input().rstrip())) for _ in range(n)]
love = dict()
pre_fix = dict()
for _ in range(k):
    word = input().rstrip()
    love[word] = 0
    for i in range(1,len(word)+1):
        pre_fix[word[:i]] = 0

print(pre_fix)
print(love)

for i in range(n):
    for j in range(m):
        if board[i][j] in pre_fix:
            bfs(i,j,board[i][j])
            if board[i][j] in love:
                love[board[i][j]] += 1

print(*love.values(), sep='\n')