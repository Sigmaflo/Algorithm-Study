# [2075] N번째 큰 수

import sys
from heapq import heappop, heappush
input = sys.stdin.readline

n = int(input())
## 입력받아서 n번째로 큰 수 출력
## N이 1500이니까 입력을 다 받아서 비교하면 메모리 초과됨
heap = []

list1 = list(map(int, input().split()))
for i in list1:
    heappush(heap, i)

for i in range(1, n):
    list2 = list(map(int, input().split()))
    for j in range(n):
        if list2[j] > heap[0]: # 최소값보다 큰 값이면 빼고 넣음
            heappop(heap)
            heappush(heap, list2[j])
# 이렇게 하면 큐에는 계속 5번째~1번째까지 제일 큰 값이 순서대로 들어가있음

print(heap[0])
