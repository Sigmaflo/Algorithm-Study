import sys
sys.stdin = open("input.txt", "r")
input = sys.stdin.readline

n = int(input())
nums = [int(input()) for _ in range(n)]

asc = [0]
desc = [0]

for i in range(n):
    asc.append(asc[-1]+nums[i])
    desc.append(desc[-1]+nums[n-i-1])


ans = []
for i in range(n//2+1):
    for j in range(i+1, n+1):
        ans.append(min(asc[j] - asc[i], asc[n] - asc[j] + asc[i]))
print(ans)
print(max(ans))