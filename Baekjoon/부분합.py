import sys
# sys.stdin = open('부분합.txt', 'r')
input = sys.stdin.readline
n, s = map(int, input().split())
num_list = list(map(int, input().split()))

i, res = 0, len(num_list) + 1
for j in range(len(num_list)):
    s -= num_list[j]
    while s <= 0:
        res = min(res, j - i + 1)
        s += num_list[i]
        i += 1
print(res % (len(num_list) + 1))