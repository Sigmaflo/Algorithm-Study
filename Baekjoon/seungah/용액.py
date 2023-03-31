# [2467] 용액 (골드 5)
import sys
input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))
nums.sort()

left=0
right=len(nums)-1
a, b = nums[left], nums[right]
ans_t = abs(a+b)
while left < right:
    tmp = nums[left] + nums[right]
    
    #print(left, right, nums[left], nums[right], tmp)

    if abs(tmp) < ans_t:
        ans_t = abs(tmp)
        a, b = nums[left], nums[right]
        if ans_t == 0:
            break


    if tmp > 0:
        right -= 1
    else:
        left += 1        


print(a, b)
    
"""
반례
10
-5 -5 -5 1 1 10 10 10 10 10
answer (1, 1)

4
-100 -2 -1 10
answer (-2, -1)

7
-99 -2 -1 1 98 100 101
answer (-1, 1)

2
1000000000 1000000000

8
-100 -99 99 0 1 2 3 4 5

9
-1000000 -99 99 100 101 102 103 104 105
"""