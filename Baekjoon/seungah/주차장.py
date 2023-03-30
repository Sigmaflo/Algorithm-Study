# [5464] 주차장 (실버2)
import sys
from collections import deque
input = sys.stdin.readline
# N: 주차공간, M: 차량
N, M = map(int, input().split())

rr = [0]*N # 주차공간 (자동차 번호 담음)
# rs: 주차공간 위치별 단위 무게당 요금
rs = [int(input()) for _ in range(N)]
# 차량 k의 무게
wk = [int(input()) for _ in range(M)]

def find_in_idx():
    for i in range(N):
        if rr[i] == 0:
            return i
    return -1

def find_out_idx(car):
    for i in range(N):
        if rr[i] == car:
            return i
    return -1

ans = 0
queue = deque() # 기다리는 차량
for _ in range(2*M):
    car = int(input())
    if car > 0: # IN
        idx = find_in_idx()
        if idx < 0:
            queue.append(car)
        else:
            rr[idx] = car
            ans += wk[car-1]*rs[idx]
    elif car < 0: # OUT
        car = abs(car)
        idx = find_out_idx(car)
        rr[idx] = 0
        if queue:
            car = queue.popleft()
            rr[idx] = car
            ans += wk[car-1]*rs[idx]

print(ans)