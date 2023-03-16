#[16235] 나무 재테크 (골드 3)

import sys
input = sys.stdin.readline
from collections import deque
## 시간제한 1.3초 (python3)

N, M, K = map(int, input().split())
# N*N 크기 땅 있음
ground = [[deque() for _ in range(N)] for _ in range(N)]

# 첫 양분 초기값 5
init_soil = [[5]*N for _ in range(N)]

## S2D2가 각 칸에 뿌려주는 양분
A = list(map(int, input().split()) for _ in range(N))

## M개의 구매한 나무 (x, y, 나이)
buy_tree = list(map(int, input().split()) for _ in range(M))

## 전체 나무 그래프
trees = [ [[] for _ in range(N)] for _ in range(N)]

dx = [1, -1, 0, 0, 1, -1, 1, -1]
dy = [0, 0, -1, 1, 1, -1, -1, 1]

# 봄: 자신의 나이만큼 양분 먹고, 나이 1 증가
## 하나의 칸에 여러 개 나무 있으면 어린 나무부터 먹음


# 여름:

