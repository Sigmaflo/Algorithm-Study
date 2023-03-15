import sys,heapq
input = sys.stdin.readline

h = []
n = int(input())
for _ in range(n):
    for i in map(int,input().split()):
        if len(h)<n:
            heapq.heappush(h, i)
        else:
            if h[0]<i:
                heapq.heappop(h)
                heapq.heappush(h, i)
                
print(heapq.heappop(h))