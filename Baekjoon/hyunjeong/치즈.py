import sys
from collections import deque
input = sys.stdin.readline

n,m = map(int,input().split())
graph = []
for i in range(n):
    graph.append(list(map(int,input().split())))

dx = [1,-1,0,0]
dy = [0,0,1,-1]
ans = []