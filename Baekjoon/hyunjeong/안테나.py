import sys
# sys.stdin = open('안테나.txt', 'r')
input = sys.stdin.readline
n = int(input())
houses = list(map(int, input().split()))

houses.sort()

print(houses[(n-1)//2])







