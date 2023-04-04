import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    k = int(input())
    nums = list(map(int,input().split()))
    pre_fix = [nums[0]]
    for num in nums[1:]:pre_fix.append(pre_fix[-1] + num)
    dp = [[0] * k for _ in range(k)]

    for i in range(k-1):dp[i][i+1] = nums[i] + nums[i+1]
    
    for j in range(2, k):
        i = 0
        while i + j < k:
            for u in range(i, i+j):
                dist = pre_fix[i+j] - pre_fix[i-1] if i!=0 else pre_fix[i+j]
                if dp[i][i+j] ==0:
                    dp[i][i+j] = dp[i][u] + dp[u+1][i+j] + dist
                else:
                    dp[i][i+j] = min(dp[i][i+j], dp[i][u] + dp[u+1][i+j] + dist)
            i += 1
    print(dp[0][-1])