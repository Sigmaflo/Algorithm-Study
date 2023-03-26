import itertools

n = int(input())
signs = input().split()

max_num = -1
min_num = 10**n
for numbers in itertools.permutations(range(10), n+1):

