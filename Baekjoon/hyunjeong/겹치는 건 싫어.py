from collections import deque
import sys


sys.stdin = open('겹치는 건 싫어.txt', 'r')
input = sys.stdin.readline

n, k = map(int, input().split())
nums = [int(x) for x in input().split()]
res = 0
length = 0

# starting index of consecutive nums
start = 0

# dict to store indexes of numbers
count = {}
for i in range(len(nums)):
    # initialize deque as value if key not in count
    if nums[i] not in count:
        count[nums[i]] = deque([])

    # if more than or equal to k nums[i] in current consecutive list
    if len(count[nums[i]]) >= k:
        # update res with max length of consecutive list
        res = max(res, length)

        first_occurrence = count[nums[i]][0]
        length = i - first_occurrence
        # remove nums b/w starting point and first occurence of >k number
        for j in range(start, first_occurrence+1):
            temp = count[nums[j]].popleft()

        # append current index to count
        count[nums[i]].append(i)

        # update starting point to be from first_occurrence + 1
        start = first_occurrence + 1
    # if less than k nums[i] in current consecutive list
    else:
        count[nums[i]].append(i)
        length += 1

# print max length of consecutive list
print(max(res, length))