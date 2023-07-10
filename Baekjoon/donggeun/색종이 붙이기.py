n = 10
m = 5
board = [list(map(int,input().split())) for _ in range(n)]
ans = []

def validate(y:int,x:int,z:int):
    if y + z > n or x + z > n:
        return False
    for i in range(y, y+z):
        for j in range(x, x+z):
            if board[i][j] == 0: return False
    return True

def paint(y:int, x:int, z:int, v:int):
    for i in  range(y, y+z):
        for j in range(x, x+z):
            board[i][j] = v

def bt(s:list[int], idx:int) -> None:
    if idx >= len(one):
        global ans
        ans.append(sum(s))
        return
    
    y,x = one[idx]
    
    if board[y][x] == 0: bt(s, idx+1)
    for z in range(1, m+1):
        if s[z] < 5 and validate(y,x,z):
            paint(y,x,z,0)
            s[z] += 1
            bt(s, idx+1)
            s[z] -= 1
            paint(y,x,z,1)

one = []
for i in range(n):
    for j in range(n):
        if board[i][j] == 1:
            one.append((i,j))

bt([0]*(m+1), 0)
print(min(ans) if ans else -1)