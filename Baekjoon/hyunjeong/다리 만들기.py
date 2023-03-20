import sys

sys.stdin = open('다리 만들기.txt', 'r')
input = sys.stdin.readline
n = int(input())
map = []
for i in range(n):
    map.append(list(map(int, input().split())))

for i in range(n):
    for j in range(n):
        