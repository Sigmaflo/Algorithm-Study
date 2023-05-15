# 백트래킹, 완전탐색
# 10개에서 8개를 뽑는데 순서 중요 -> permutation

from itertools import permutations

def calc(idx: tuple[int]) -> int:
    res = 0
    energe = [True]*n
    for x in idx:
        right = x+1
        left = x-1
        while not energe[left]:
            left -= 1
        while not energe[right]:
            right += 1
    
        res += nums[left]*nums[right]
        energe[x] = False
    return res

n = int(input())
nums = list(map(int,input().split()))
ans = 0

for idx in permutations(range(1,n-1), n-2):
    ans = max(ans, calc(idx))
print(ans)