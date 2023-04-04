import itertools
import sys


sys.stdin = open('파일 합치기.txt', 'r')
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    k = int(input())
    files = [int(x) for x in input().split()]
    
    dp = [[0]*(k+1) for i in range(k+1)]
    for i in range(k-1):
        dp[i][i+1] = files[i] + files[i+1]
        for j in range(i+2, k):
            dp[i][j] = dp[i][j-1] + files[j]
    for m in range(2, k):
        for n in range(k-m):
            temp = m+n
            minimum = [dp[n][k] + dp[k+1][temp] for k in range(n, temp)]
            dp[n][temp] += min(minimum)
    print(dp[0][k-1])