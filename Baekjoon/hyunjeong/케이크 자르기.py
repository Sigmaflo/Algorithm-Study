import sys


sys.stdin = open('케이크 자르기.txt', 'r')
input = sys.stdin.readline

n, m, l = map(int, input().split())
s = [int(input()) for _ in range(m)]
q = [int(input()) for _ in range(n)]