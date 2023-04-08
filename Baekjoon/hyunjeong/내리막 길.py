import sys


input = sys.stdin.readline
m, n = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(m)]
visited = [[-1]*n for _ in range(m)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

stack = [(0, 0)]
