import sys


sys.stdin = open('뱀.txt', 'r')
input = sys.stdin.readline

n = int(input())
k = int(input())
apple_locs = set([])
for _ in range(k):
    apple_locs.add(tuple(map(int, input().split())))

l = int(input())
dir_change_times = {}
for _ in range(l):
    x, c = map(int, input().split())
    dir_change_times[x] = c

cur_loc = (0, 0)
dxdys = {''}
dir_change = {}

while True:



    