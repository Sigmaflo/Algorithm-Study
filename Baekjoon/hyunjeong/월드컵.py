from itertools import combinations
import sys


input = sys.stdin.readline
res = []
game = list(combinations(range(6), 2))

for _ in range(4):
    data = list(map(int, input().split()))
    
