from collections import deque
import sys


sys.stdin = open('문제집.txt', 'r')
input = sys.stdin.readline

n, m = map(int, input().split())
prereqs = []
for _ in range(m):
    temp = tuple(map(int, input().split()))
    prereqs.append(temp)

prereqs.sort(key = lambda x:x[0])
orders = deque([x for x in range(1, n+1)])
    
for prereq in prereqs:
    a, b = prereq
# iterate order and insert a, b
    len_orders = len(orders)
    found_a = False
    inserted_b = False
    for i in range(len_orders):
        front = orders.popleft()
        if front == b:
            continue
        if front == a:
            found_a = True
        if found_a and front > b and not inserted_b:
            orders.append(b)
            inserted_b = True
        orders.append(front)   
        print(orders)                    


print(*orders)