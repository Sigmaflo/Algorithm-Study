import sys
import heapq
sys.stdin = open('N번째 큰 수.txt', 'r')
input = sys.stdin.readline

n = int(input())
grid = []
for i in range(n):
    grid.append(list(map(int, input().split())))

pq = []
for i in range(n):
    for j in range(n):
        heapq.heappush(pq, grid[i][j])
        if len(pq) > n:
            heapq.heappop(pq)


print(pq[0])
