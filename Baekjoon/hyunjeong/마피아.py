import sys

input = sys.stdin.readline
n = int(input())
guilty = list(map(int, input().split()))
r = []
for i in range(n):
    r.append(list(map(int, input().split())))
participants = list(map(int, input().split()))

