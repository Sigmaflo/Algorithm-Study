import sys


sys.stdin = ('선발 명단.txt', 'r')
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    