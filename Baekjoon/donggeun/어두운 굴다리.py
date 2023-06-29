def canbe(h:int) -> bool:
    pre = 0

    for num in nums:
        if num - h > pre: # 현재 위치에서 - h
            return False
        else:
            pre = h + num
    return pre >= n

n = int(input())
m = int(input())
nums = list(map(int,input().split()))

st,ed = 0, n
ans = []

while st <= ed:
    mid = (st + ed) // 2

    if canbe(mid):
        ans.append(mid)
        ed = mid - 1
    else:
        st = mid + 1

print(min(ans))
