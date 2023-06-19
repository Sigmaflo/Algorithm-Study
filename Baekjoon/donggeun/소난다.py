from itertools import combinations
n,m = map(int,input().split())
k = 9000
nums = list(map(int,input().split()))
primes = [True for i in range(k+1)]
primes[0], primes[1] = False, False

ans = set()

for i in range(2, int(k**0.5)+1):
    if primes[i]:
        j = 2
        while i*j <= k:
            primes[i*j] = False
            j+=1


for x in combinations(nums, m):
    if primes[sum(x)]:
        ans.add(sum(x))

if ans:
    print(*sorted(ans))
else:
    print(-1)
