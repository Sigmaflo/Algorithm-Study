import heapq
import sys


sys.stdin = open('대표 선수.txt', 'r')
input = sys.stdin.readline

n, m = map(int, input().split())

total = []
for i in range(n):
    temp = list(map(int, input().split()))
    temp.sort()
    for j in range(m):
        heapq.heappush(total, (temp[j], i))
print(total)
# l = 0
# r = 10**9
# while l <= r:
#     mid = (l+r)//2
