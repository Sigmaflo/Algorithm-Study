import sys

N, D = map(int, input().split())

shortcuts = []
for i in range(N):
    s, e, d = map(int, input().split())
    shortcuts.append((s, e, d))

shortcuts.sort()

pos = 0
dist = 0
for i in range(N):


print(dist)
