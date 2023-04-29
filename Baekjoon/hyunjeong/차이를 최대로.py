from itertools import permutations
import sys


sys.stdin = open('차이를 최대로.txt', 'r')
input = sys.stdin.readline

n = int(input())
nums = list(map(int, input().split()))
perm_nums = list(permutations(nums, r = n))

res = 0
for num_list in perm_nums:
    temp_res = 0
    for i in range(1, len(num_list)):
        temp_res += abs(num_list[i-1] - num_list[i])
    res = max(res, temp_res)

print(res)

# time complexity = O(n!*n)
# space complexity = O(n!*n)