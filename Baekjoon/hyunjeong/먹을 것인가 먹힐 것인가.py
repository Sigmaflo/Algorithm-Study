import sys
# sys.stdin = open('먹을 것인가 먹힐 것인가.txt', 'r')
input = sys.stdin.readline
num = int(input())
for i in range(num):
    a_num, b_num = map(int, input().split())
    a_list = list(map(int, input().split()))
    b_list = list(map(int, input().split()))
    count = 0
    a_list.sort()
    b_list.sort()
    i = 0
    j = len(b_list) - 1
    while i < len(a_list) and j >= 0:
        if a_list[i] > b_list[j]:
            count += j + 1
            # print(i, j)
            i += 1
            j = len(b_list) - 1
        else:
            j -= 1
        if j < 0 and i < len(a_list):
            i += 1
            j = len(b_list) - 1

    print(count)

