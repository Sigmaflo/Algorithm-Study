import sys
input = sys.stdin.readline

n,m = map(int,input().split())
boy = sorted(list(map(int,input().split())))
girl = sorted(list(map(int,input().split())))
INF = sys.maxsize

if n < m:
    n,m = m,n
    boy, girl = girl, boy

dp = [[INF]*(m+1) for _ in range(n+1)]



dp[0][0] = 0

for i in range(n): # 남자
    for j in range(m): # 여자
        dp[i+1][j] = min(dp[i][j], dp[i+1][j])
        dp[i+1][j+1] = min(dp[i+1][j+1], dp[i][j] + abs(boy[i] - girl[j]))

print(dp[n][m])