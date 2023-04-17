import sys


input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

for i in range(n-1, 0, -1):
    if arr[i] < arr[i-1]:
        x, y = i-1, i
        for j in range(n-1, 0, -1):
            if arr[j] < arr[x]:
                arr[j], arr[x] = arr[x], arr[j]
                a = a[:i] + sorted(a[i:], reverse = True)
                print(*a)
                exit(0)
print(-1)
