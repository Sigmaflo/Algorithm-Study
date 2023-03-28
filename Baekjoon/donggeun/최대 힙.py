import sys, heapq
input = sys.stdin.readline

n = int(input())
hq = []

for _ in range(n):
    x = int(input())
    if x:
        heapq.heappush(hq, -x)
    else:
        print(-heapq.heappop(hq) if hq else 0)