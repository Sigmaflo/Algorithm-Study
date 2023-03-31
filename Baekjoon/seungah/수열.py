# [2559] 수열 (실버 3)
import sys
input=sys.stdin.readline

N, K = map(int, input().split())
nums = [0]+list(map(int, input().split()))
sum_nums = [0]
tmp = 0

for i in range(1, len(nums)):
    tmp += nums[i]
    sum_nums.append(tmp)

ans = sum_nums[K]
for i in range(K+1, len(sum_nums)):
    tmp = sum_nums[i] - sum_nums[i-K]
    ans = max(ans, tmp)

print(ans)
