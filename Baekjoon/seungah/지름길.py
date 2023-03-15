# [1446] 지름길

import sys
input = sys.stdin.readline

N, D = map(int, input().split())

## 0~D까지 -> D 넘으면 안됨! (역주행 불가능)
## D는 10000보다 작으니까 DP 가능

dp = [0]*(D+1)
for i in range(D+1):
    dp[i] = i

shortcut = []
for i in range(N):
    shortcut.append(list(map(int, input().split())))

shortcut.sort(key=lambda x:(x[0], x[1]))

## 방법 1. D 개수만큼 돌면서 지름길 확인
# for i in range(D+1):
#     if i>0:
#         dp[i] = min(dp[i], dp[i-1]+1)

#     for start, end, dist in shortcut:
#         if start == i and end <= D: # 현재 길에서 지름길이 시작되면
#             if dp[i]+dist < dp[end]: # 현재 end 까지 값보다 작으면 update
#                 dp[end] = dp[i]+dist

# print(dp[D])

## 방법 2. 지름길 개수만큼 돌면서 계속 값 update
for start, end, dist in shortcut:
    if end <= D and dp[end] > dp[start]+dist: # 현재 지름길이 원래 길보다 짧으면 update
        dp[end] = dp[start]+dist
        cnt = 1
        for i in range(end+1, D+1): # 이후 길들도 지름길 사용하도록 update
            dp[i] = dp[end]+cnt
            cnt+=1


print(dp[D])