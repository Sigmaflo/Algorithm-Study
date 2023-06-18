def bt(s:list, tot:int):
    if (1 < len(s) <= n) and (l <= tot) and nums[s[-1]] - nums[s[0]] >= x:
        global ans
        ans += 1

    for i in range(n):
        if ((s and s[-1] < i) or (not s)) and tot + nums[i] <= r:
            s.append(i)
            bt(s, tot + nums[i])
            s.pop()

n,l,r,x = map(int,input().split())
nums = list(map(int,input().split()))
nums.sort()
ans = 0

bt([], 0)
print(ans)