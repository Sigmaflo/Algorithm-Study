import sys


input = sys.stdin.readline

n = int(input())
items = {}
for _ in range(n):
    i1, i2 = map(str, input().split())
    if i1 not in items:
        items[i1] = {}
        items[i1]['list'] = []
        items[i1]['count'] = 0
    else:
        items[i1]['list'].append(i2)

    if i2 not in items:
        items[i2] = {}
        items[i2]['list'] = []
        items[i2]['count'] = 1
    else:
        items[i2]['count'] += 1
