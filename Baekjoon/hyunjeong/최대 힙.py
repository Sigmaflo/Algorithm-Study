import sys
import heapq
# sys.stdin = open('최대 힙.txt', 'r')
input = sys.stdin.readline

n = int(input())
nums = []
for i in range(n):
    nums.append(-int(input()))

res = []
for i in range(n):
    # print(i)
    if nums[i] == 0:
        if not res:
            print(0)
        else:
            print(-heapq.heappop(res))
    else:
        heapq.heappush(res, nums[i])
