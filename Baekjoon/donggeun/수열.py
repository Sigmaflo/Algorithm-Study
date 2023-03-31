import sys
input = sys.stdin.readline

n, k = map(int, input().rstrip().split())
temp = list(map(int, input().rstrip().split()))
arr = sum(temp[:k])
res = [arr]

for i in range(0, len(temp)-k):
    arr = arr - temp[i] + temp[i+k]
    res.append(arr)
print(max(res))