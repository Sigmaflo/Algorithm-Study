import heapq

n = int(input())

l = []
r = []

for i in range(n):
    num = int(input())
    
    if len(l) == len(r):
        heapq.heappush(l, (-num, num))
    else:
        heapq.heappush(r, num)
    
    if r and l[0][1] > r[0]:
        
    

