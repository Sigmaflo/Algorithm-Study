import sys
sys.stdin = open('말이 되고픈 원숭이.txt', 'r')
input = sys.stdin.readline
k = int(input())
w, h = map(int, input().split())
grid = []
for i in range(h):
    grid.append(list(map(int, input().split())))
