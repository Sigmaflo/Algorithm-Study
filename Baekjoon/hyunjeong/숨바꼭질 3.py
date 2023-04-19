from collections import deque
import sys


sys.stdin = open('숨바꼭질 3.txt', 'r')
input = sys.stdin.readline

n, k = map(int, input().split())

queue = deque([(n, 0)])
visited = set([n])
res = 1e9

while queue:
    cur, time = queue.popleft()

    if cur == k:
        res = min(res, time)
        continue
    
    if 2*cur not in visited and 2*cur <= 100000: #set limits
        queue.append((2*cur, time))
        visited.add(2*cur)
    if cur-1 not in visited and cur-1 >= 0:
        queue.append((cur-1, time+1))
        visited.add(cur-1)
    if cur+1 not in visited and cur+1 <= 100000:
        queue.append((cur+1, time+1))
        visited.add(cur+1)

print(res)
    