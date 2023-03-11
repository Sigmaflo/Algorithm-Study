# 2805 나무 자르기

import sys
input = sys.stdin.readline

n, m = map(int, input().split())
wood = list(map(int, input().split()))

start = 1
end = max(wood)
ans = 0
while (start <= end):
    mid = (start+end)//2
    target = 0

    for w in wood:
        if w > mid: ## 클 경우에만 ++
            target += (w-mid)

    if target >= m:
        start = mid + 1
        ans = max(ans, mid)
    else:
        end = mid - 1

print(ans)