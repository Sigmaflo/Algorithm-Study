def bt(s,idx):
    if len(s) == k+1:
        global candi
        candi.append(s[::])
        return
    if idx >= k:
        return
    for num in nums:
        if visit[num]:
            continue
        if not s:
            s.append(num)
            visit[num] = True
            bt(s, idx)
            visit[num] = False
            s.pop()
        elif eval(str(s[-1]) + equals[idx] + str(num)):
            s.append(num)
            visit[num] = True
            bt(s, idx+1)
            visit[num] = False
            s.pop()

k = int(input())
equals = list(map(str,input().rstrip().split()))
ans = []
candi = []
nums = [i for i in range(10)]
visit = [False]*(10)

bt([], 0)
print(*candi[-1],sep='')
print(*candi[0],sep='')