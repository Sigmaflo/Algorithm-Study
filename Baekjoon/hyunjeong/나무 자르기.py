import sys
# sys.stdin = open('나무 자르기.txt', 'r')
input = sys.stdin.readline
n, m = map(int, input().split())
trees = list(map(int, input().split()))

down, up = 0, max(trees)
while down <= up:
    mid = (down + up)//2
    total = sum([x-mid for x in trees if x >= mid])
    if total >= m:
        down = mid + 1
    else:
        up = mid -1
print(up)


