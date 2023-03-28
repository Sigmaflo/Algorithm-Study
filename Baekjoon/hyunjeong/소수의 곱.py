import heapq
import sys
from queue import PriorityQueue

sys.stdin = open('소수의 곱.txt', 'r')
input = sys.stdin.readline

k, n = map(int, input().split())
nums = [int(x) for x in input().split()]

products = PriorityQueue()
for num in nums:
    products.put(num)
seen = set(nums)
index = 0

while index < n:
    # get smallest product and pop it off products
    small = products.get()

    # loop through 소수
    for i in range(k):
        val = small * nums[i]

        # append val to products only when it hasn't been seen before
        if val not in seen:
            products.put(val)
            seen.add(val)
        
        # 중복을 방지하기 위해 큐에서 뺀 숫자의 약수가 소수 중에 있다면 더이상 곱하는걸 멈춘다.
        # if small % nums[i] == 0:
        #     break
    # update index
    index += 1

# print the nth element
print(small)
