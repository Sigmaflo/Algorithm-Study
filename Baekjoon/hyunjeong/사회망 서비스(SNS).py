import sys


sys.stdin = open('사회망 서비스.txt', 'r')
input = sys.stdin.readline
n = int(input())
c = [[] for i in range(n+1)]
dp = [[0,0] for i in range(n+1)]

for _ in range(n-1):
    a,b = map(int , input().split(" "))
    c[a].append(b)
    c[b].append(a)