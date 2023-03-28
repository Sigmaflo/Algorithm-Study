import sys, heapq
input = sys.stdin.readline

k,n = map(int,input().split())
nums = list(map(int,input().split()))
visit = set()
hq = []
primes = []
max_num = 0

for num in nums:
    heapq.heappush(hq, num)
    max_num = max(num, max_num)
    primes.append(num)

while 0 < n-1:
    num = heapq.heappop(hq)
            
    for i in range(k):
        val = num * primes[i]

        if len(hq) >= n and val >= max_num:
            continue
        if val not in visit:
            visit.add(val)
            heapq.heappush(hq, val)
            max_num = max(max_num, val)
    n -= 1
print(heapq.heappop(hq))