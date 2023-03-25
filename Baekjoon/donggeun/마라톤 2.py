# 완탐은 시초
# 그렇다면 그리디?
# 아니면 dp 혹은 bfs 돌리는건가 다익스트라
import sys
input = sys.stdin.readline

n,k = map(int,input().split())
board = [list(map(int,input().split())) for _ in range(n)]
distance = []

pre_x, pre_y = board[0][0], board[0][1]

for aft_x, aft_y in board[1:]:
    distance.append(abs(pre_x-aft_x) + abs(pre_y - aft_y))

print(distance)