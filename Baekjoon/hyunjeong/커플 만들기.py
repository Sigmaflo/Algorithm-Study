from collections import deque
import sys


sys.stdin = open('커플 만들기.txt', 'r')
input = sys.stdin.readline
m, w = map(int, input().split())
men = [int(x) for x in input().split()]
women = [int(x) for x in input().split()]
men.sort()
women.sort()
res = float('inf')
# print(men)
# print(women)
for i in range(min(m, w)):
    res = min(res, abs(men[i]-women[i]))
print(res)
