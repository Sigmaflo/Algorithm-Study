import sys
input = sys.stdin.readline

def turn(pos:list[list[int]]) -> list[list[int]]:
    n = len(pos)
    m = len(pos[0])

    res = [[0]*n for _ in range(m)]

    for j in range(m):
        for i in range(n):
            res[j][n-i-1] = pos[i][j]

    return res

def check(form:list[list[int]], r:int, c:int, y:int, x:int):
    if r+y > n or c+x > m: return False
    for i in range(r, r+y):
        for j in range(c, c+x):
            if form[i-r][j-c] == 1 and board[i][j] == 1:
                return False
    return True

def color(form:list[list[int]], r:int, c:int, y:int, x:int):
    for i in range(r, r+y):
        for j in range(c, c+x):
            if form[i-r][j-c] == 1:
                board[i][j] = form[i-r][j-c]


def cycle(form:list[list[int]]): # 이 모양으로 성공함
    y = len(form)
    x = len(form[0])
    for r in range(n):
        for c in range(m):
            if check(form, r, c, y, x):
                color(form, r, c, y, x)
                return True
    return False

n,m,k = map(int,input().split())
size = dict()
position = dict()
board = [[0]*m for _ in range(n)]

for i in range(k):
    r,c = map(int,input().split())
    size[i] = (r,c)
    position[i] = [list(map(int,input().split())) for _ in range(r)]


for idx in range(k):
    y,x = size[idx]
    form = position[idx]
    for _ in range(4):
        if cycle(form): break
        form = turn(form)

print(sum(map(sum, board)))