import sys


sys.stdin = open('행렬.txt', 'r')
input = sys.stdin.readline

n, b = map(int, input().split())
lines = []
for _ in range(n):
    lines.append(list(map(int, input().split())))