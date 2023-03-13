import sys
# sys.stdin = open('새로운 게임.txt', 'r')
input = sys.stdin.readline
n, k = map(int, input().split())
board = []
horses = []
for i in range(n):
    board.append(list(map(int, input().split())))
for i in range(k):
    horses.append(list(map(int, input().split())))
