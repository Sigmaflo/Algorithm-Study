import sys
input = sys.stdin.readline

n = int(input())
nums = list(map(int,input().split()))
res = [0] * n
for i in range(n):
    min_lean = -(1000000000) - 1

    for j in range(i+1, n):
        x = j - i
        y = nums[j] - nums[i]
        if x and min_lean < y/x:
            min_lean = y/x
            res[i] += 1
            res[j] += 1
        elif not x and min_lean < 0:
            min_lean = 0
            res[i] += 1
            res[j] += 1

print(max(res))