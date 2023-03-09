import sys
# sys.stdin = open('섬의 개수.txt', 'r')
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

def dfs(i, j):
    if i < 0 or i >= h or j < 0 or j >= w:
        return
    if map[i][j] == "0":
        return
    map[i][j] = "0"
    dfs(i-1, j)
    dfs(i+1, j)
    dfs(i, j+1)
    dfs(i, j-1)
    dfs(i-1, j-1)
    dfs(i-1, j+1)
    dfs(i+1, j-1)
    dfs(i+1, j+1)

while True:
    w, h = input().split()
    w = int(w)
    h = int(h)
    if w == 0 and h == 0:
        break
    map = []
    count = 0
    for i in range(h):
        map.append(input().split())
    for i in range(h):
        for j in range(w):
            if map[i][j] == "1":
                dfs(i, j)
                count += 1
    print(count)
