import sys
input = sys.stdin.readline

def collocate(dist: int) -> bool:
    cnt = 1
    pre = 0
    for i in range(1, n):
        if nums[i] - nums[pre] >= dist:
            pre = i
            cnt += 1
    return cnt >= c

n,c = map(int,input().split())
nums = sorted([int(input()) for _ in range(n)])

left, right = 1, nums[-1] - nums[0]
res = 0
while left <= right:
    mid = (left + right) // 2

    if collocate(mid):
        res = mid
        left = mid + 1
    else:
        right = mid - 1

print(res)