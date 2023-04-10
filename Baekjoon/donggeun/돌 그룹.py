import heapq

nums = list(map(int,input().split()))
hq = []
cnt = 0

for num in nums:
    heapq.heappush(hq, num)

while hq:
    cnt += 1
    a = heapq.heappop(hq)
    b = heapq.heappop(hq)
    c = heapq.heappop(hq)

    if a==b==c:
        print(1)
        break
    elif a==b or b==c:
        print(0)
        break
    heapq.heappush(hq, a+a)
    heapq.heappush(hq, b)
    heapq.heappush(hq, c-a)

    if cnt > 1000:
        print(0)
        break