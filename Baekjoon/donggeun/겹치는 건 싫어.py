from collections import defaultdict as dd

n,k = map(int,input().split())
nums = list(map(int,input().split()))

count = dd(int)

one, two = 0, 1
count[nums[one]] += 1

ans = 1
while two < n:
    if count[nums[two]] >= k:
        count[nums[one]] -= 1
        ans = max(ans, two - one)
        one += 1
    else:
        count[nums[two]] += 1
        ans = max(ans, two - one+1)
        two += 1

print(ans)