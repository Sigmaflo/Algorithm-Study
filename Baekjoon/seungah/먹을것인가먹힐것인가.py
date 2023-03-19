# [7795] 먹을 것인가 먹힐 것인가 (실버 3)
import sys
input =sys.stdin.readline
T = int(input())

def BS(find_list, target):
    left = 0
    right = len(find_list)
    while left < right:
        mid = (left+right)//2
        if find_list[mid] < target:
            left = mid+1
        else:
            right = mid
    return right

for t in range(T):
    N, M = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
    A.sort()
    B.sort()
    answer = 0
    for a in A:
        answer += BS(B, a) ##
    print(answer)


