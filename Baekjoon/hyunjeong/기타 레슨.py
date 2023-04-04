import sys


sys.stdin = open('기타 레슨.txt', 'r')
input = sys.stdin.readline

n, m = map(int, input().split())
lectures = [int(x) for x in input().split()]

# size of disc between max(lectures) and sum(lectures)
l, r = max(lectures), sum(lectures)
while l <= r:
    mid = (l+r)//2

    # count how many discs are needed
    count = 1
    sum = 0
    for i in range(n):
        if sum+lectures[i] > mid:
            count += 1
            sum = 0
        sum += lectures[i]
    
    # if need more discs
    if count <= m:
        r = mid -1
    # if need less discs
    else:
        l = mid+1

print(l)
    