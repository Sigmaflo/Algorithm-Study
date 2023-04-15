import sys


sys.stdin = open('합분해.txt', 'r')
input = sys.stdin.readline

n, k = map(int, input().split())
nums = list(range(0, n+1))

# dp[i][j] = number of ways to make j with i number of nums
dp = [[0]*(n+1) for _ in range(k+1)]

for i in range(1, k+1):
    for j in range(1, n+1):
        if i == 1:
            dp[i][j] = 1
        # elif i == 2:
        #     dp[i][j] = j+1
        elif j == 1:
            dp[i][j] = i
        else:
            dp[i][j] = dp[i-1][j] + dp[i][j-1]
print(dp[k][n] % 1000000000)