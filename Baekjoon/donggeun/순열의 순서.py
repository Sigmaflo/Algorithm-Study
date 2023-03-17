import math

n = int(input())
cmd = list(map(int,input().split()))

if cmd[0] == 1:
    k = cmd[1] - 1
    order = []
    ans = []
    nums = [i for i in range(1, n+1)]
    for cnt in range(n-1, -1, -1):
        tmp = k//math.factorial(cnt)
        k %= math.factorial(cnt)
        
        ans.append(nums[tmp])
        nums.remove(nums[tmp])

    print(*ans)
else:
    permu = cmd[1:]
    candi = set([i for i in range(1, n+1)])
    
    cnt = n-1
    ans = 1
    for idx, val in enumerate(permu, 1):
        ans += sorted(list(candi)).index(val) * math.factorial(cnt)
        candi -= {val}
        cnt -= 1

    print(ans)