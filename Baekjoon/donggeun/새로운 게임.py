import sys
input = sys.stdin.readline


# 0: 흰색, 1: 빨간색, 2: 파란색
# <-, ->, ^, v

dx = [1,0,0,-1,1]
dy = [1,-1,1,0,0]

def red(lis):
    return reversed(lis)

def blue(w):
    if w == 1:
        return 2
    if w == 2:
        return 1
    if w == 3:
        return 4
    return 3

n,k = map(int,input().split())
board = [list(map(int,input().split())) for _ in range(n)]
mal = [[0]*(n+1) for _ in range(n+1)]
mal_list = []
for _ in range(k):
    y,x,w = map(int,input().split())
    mal[y][x] = w
    mal_list.append([y,x,w])

for y, x, w in mal_list:
    pass

        

# 턴이 종료되는 순간은 말 4개