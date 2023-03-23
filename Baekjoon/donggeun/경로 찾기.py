import sys
input = sys.stdin.readline

mod = int(1e6) + 7
n,m,c = map(int,input().split())
game = dict()
for i in range(1, c+1):
    a,b = map(int,input().split())
    game[(a-1, b-1)] = i

dp = [[[0]*(m+1) for _ in range(n+1)] for __ in range(c+1)]
dp[0][0][1] = 1
# cnt = 0
for cnt in range(c):
    for y in range(1, n+1):
        for x in range(1, m+1):
            if (y,x) in game:
                dp[cnt+1][y][x] += dp[cnt][y-1][x] + dp[cnt][y][x-1]
            else:
                dp[cnt][y][x] += (dp[cnt][y-1][x] + dp[cnt][y][x-1]) % mod

# print(dp)
for cnt in range(c+1):
    print(dp[cnt][n-1][m-1], end=' ')
