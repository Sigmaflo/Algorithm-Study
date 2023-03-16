import sys
input = sys.stdin.readline
n, m, k = map(int, input().split())

a = [list(map(int,input().split())) for _ in range(n)]
info = []
for i in range(m):
    x, y, z = map(int, input().split())
    info.append((x,y,z))
    