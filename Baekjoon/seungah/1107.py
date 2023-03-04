# [1107] 리모컨 (브루트포스 알고리즘)

import sys
input = sys.stdin.readline

N = int(input())
M = int(input())

mList = list(map(int, input().split()))

answer = abs(100-N) # 100에서 +만 눌러서 이동

# N으로 이동하기 위해 버튼을 최소 몇 번 누르는가?
## ex. 5457 -> 5455 + + => 6


for num in range(1000001):
    nums = str(num)
    for i in range(len(nums)):
        if int(nums[i]) in mList:
            break
            
        elif i == len(nums)-1:
            answer = min(answer, len(str(nums)) + abs(N-num)) # 해당 번호 이동 후 +-로 이동한 횟수와 비교


print(answer)
