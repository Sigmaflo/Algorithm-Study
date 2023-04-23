import math

mod = int(1e4)+7
n = int(input())
dp = [[0]*14 for _ in range(n+1)]
dp[0][0] = 1

for i in range(n):
    for j in range(13):
        for k in range(4):
            if i + k > n:
                continue
            dp[i+k][j+1] += dp[i][j] * math.comb(4, k)

idx = 1
ans = 0

while 4*idx <= n:
    ans = (ans + math.comb(13, idx) * dp[n-4*idx][13-idx])%mod
    idx += 1

print(ans)