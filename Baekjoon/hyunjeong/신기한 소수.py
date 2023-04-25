import sys


def is_prime(num):
    num = int(num)
    for i in range(2, int(num**(0.5))+1):
        if num % i == 0:
            return False
    return True

def dfs(num):
    if len(num) == n:
        print(num)
        return
    for i in ['1', '3', '7', '9']:
        if is_prime(num+i):
            dfs(num+i)

sys.setrecursionlimit(100000000)
sys.stdin = open('신기한 소수.txt', 'r')
input = sys.stdin.readline
n = int(input())

for num in ['2', '3', '5', '7']:
    dfs(num)






