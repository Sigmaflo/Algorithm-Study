from collections import Counter
import sys


sys.stdin = open('택배.txt', 'r')
input = sys.stdin.readline
n, c = map(int, input().split())
m = int(input())
infos = []
for _ in range(m):
    infos.append(tuple(map(int, input().split())))

infos.sort(key=lambda x: x[1])
village = [0] * (n+1)
res = 0
for f, t, s in infos:
    temp = s
    for i in range(f, t):
    
        if village[i] + temp >= c:
            temp = c - village[i]
    for i in range(f, t):
        village[i] += temp
    res += temp

print(res)





