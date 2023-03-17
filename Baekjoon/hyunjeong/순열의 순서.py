import sys
# sys.stdin = open('순열의 순서.txt', 'r')
input = sys.stdin.readline

n = int(input())
temp = list(map(int, input().split()))
if temp[0] == 1:
    k = temp[1]
else:
    num_list = temp[1:]

