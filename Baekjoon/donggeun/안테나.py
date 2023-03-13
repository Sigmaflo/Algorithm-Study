import sys
input = sys.stdin.readline


## 첫번째 풀이
## dp 

def first():
    res = 0
    for i in range(1, n):
        res += nums[i] - nums[0]
    return res

def between():
    res = [0]
    for i in range(n-1):
        res.append(nums[i+1] - nums[i])
    return res

n = int(input())
dp = [0]*n
nums = sorted(list(map(int,input().split())))
dist = between()
dp[0] = first()

plus = 0
minus = n-2
for idx, num in enumerate(nums[1:], 1):
    dp[idx] = dp[idx-1] + dist[idx]*plus - dist[idx]*minus
    plus += 1
    minus -= 1

print(nums[dp.index(min(dp))])

## 두번쨰 풀이
## 그리디
n = int(input())
nums = list(map(int,input().split()))
nums.sort()
print(nums[(n-1)//2])