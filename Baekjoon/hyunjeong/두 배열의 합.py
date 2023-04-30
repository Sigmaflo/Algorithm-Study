from collections import Counter
import sys


sys.stdin = open('두 배열의 합.txt', 'r')
input = sys.stdin.readline

target = int(input())

n = int(input())
a_list = list(map(int, input().split()))
m = int(input())
b_list = list(map(int, input().split()))

res = 0
sum_count = Counter()

# update count of sum of consecutive numbers in a_list
for i in range(n):
    for j in range(i, n):
        cur_sum = sum(a_list[i:j+1])
        sum_count[cur_sum] += 1

# if target - sum of consecutive numbers in b_list is in sum_count,
# add the count to result
for i in range(m):
    for j in range(i, m):
        tar_sum = target - sum(b_list[i:j+1])
        res += sum_count[tar_sum]

print(res)