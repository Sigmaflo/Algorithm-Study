## [1722] 순열의 순서 (골드 5)

import sys
input = sys.stdin.readline
from collections import deque
import itertools

N = int(input())
IN = deque(map(int, input().split()))
num = IN.popleft()


"""
메모리 초과

# 1~N까지 임의 배열 순열은 총 N! 가지
arr = []
for i in range(1, N+1):
    arr.append(i)

arr = list(map(str, arr))
nPr = list(map(''.join, itertools.permutations(arr, N)))
nPr = list(set(map(int, nPr)))
nPr = sorted(nPr)

answer = 0
## num 1이면 -> k번쨰 순열 구함
if num == 1:
    k = IN.popleft()
    answer = ' '.join(str(nPr[k-1]))

## num 2이면 -> (나온 숫자)가 몇 번째 수열인지 구함
elif num == 2:
    k = []
    for i in range(N):
        k.append(str(IN.popleft()))
    k = "".join(k)
    for i in range(len(nPr)):
        if int(nPr[i]) == int(k):
            answer = i+1
            break

print(answer)
"""