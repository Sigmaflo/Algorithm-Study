# [1600] 말이 되고픈 원숭이
from collections import deque
K = int(input())
W, H = map(int, input().split())

kx = [2, 1, -1, -1, 2, 1, -2, -2]
ky = [1, 2, 2, -2, -1, -2, -1, 1]

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

zoo = []
visited = [[[0]*31]*W for _ in range(H)]

for i in range(H):
    tmp = list(map(int, input().split()))
    tmp = [-1 if i==1 else i for i in tmp]
    zoo.append(tmp)


# for i in range(H):
#     print(zoo[i])

def BFS():
    q = deque()
    q.append([0,0,0]) # (시작 인덱스), 0(k사용횟수)
    visited[0][0][0] = 1


