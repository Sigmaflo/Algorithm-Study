import sys


# checks if each length divided by q points is >= mid
def is_q_points(mid):
    left = 0
    count = 0
    for right in cutting_points:
        if right - left >= mid:
            left = right
            count += 1
    return count > q

sys.stdin = open('케이크 자르기.txt', 'r')
input = sys.stdin.readline

# n = number of cuts
# m = number of cutting points
# l = length of cake
n, m, l = map(int, input().split())
cutting_points = [int(input()) for _ in range(m)]

# to consider the length from the last cut point to the end of the cake
cutting_points.append(l)
for _ in range(n):
    # need to select q number of points from cutting_points
    # s.t the least longest piece's length is maximized
    q = int(input())

    left = 1
    right = l
    res = 0

    # perform binary search to fine the maximum length
    while left <= right:
        mid = (left + right)//2
        if is_q_points(mid):
            left = mid + 1
            res = max(mid, res)
        else:
            right = mid - 1 
    
    print(res)
