import sys


sys.stdin = open('IF문 좀 대신 써줘.txt', 'r')
input = sys.stdin.readline

n, m = map(int, input().split())
names = {}
standards = []
for _ in range(n):
    a, b = map(str, input().split())

    if int(b) not in names:
        names[int(b)] = []
    names[int(b)].append(a)
    standards.append(int(b))

for _ in range(m):
    power = int(input())
    l, r = 0, n-1
    res = 1e9
    while l <= r:
        mid = (l+r)//2
        if standards[mid] >= power:
            r = mid - 1
            res = standards[mid]
        else:
            l = mid + 1
    print(names[res][0])

# time complexity: O(m * log n)
# space complexity: O(n)