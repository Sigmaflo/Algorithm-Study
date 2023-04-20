import heapq
import sys


# sys.stdin = open('최소 힙.txt', 'r')
input = sys.stdin.readline

n = int(input())
heap = []

for _ in range(n):
    num = int(input())

    # if num == natural number push num into heap
    if num != 0:
        heapq.heappush(heap, num)
    # if num == 0 print and pop least element in heap
    else:
        if heap:
            small = heapq.heappop(heap)
        else:
            small = 0
        print(small)
