# 점이 두개 붙어있으면 *3, 떨어져있으면 *4

n = int(input())
a,b = 1,0
ans = 2
dp = [0]*n
tmp = [0]*n
dp[0] = 1

MOD = int(1e4)+7
for i in range(n-2):
    ans = ((dp[0]*3 + sum(dp[1:])*4)*2)%MOD   
    tmp = dp[::]
    dp[0] = tmp[0]*2 + tmp[1]
    for j in range(1,n-1):
        dp[j] = tmp[j]*2 + tmp[j+1] + tmp[j-1]

print(ans)