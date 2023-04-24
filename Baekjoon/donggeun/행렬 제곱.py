import sys
input = sys.stdin.readline

mod = int(1e3)

def identity(n:int) -> list[list[int]]:
    return [[0 if i!=j else 1 for j in range(n)] for i in range(n)]

def product(A:list[list[int]], B:list[list[int]]) -> list[list[int]]:
    return [[sum(a*b for a, b in zip(A_row, B_col))%mod for B_col in zip(*B)] for A_row in A]

def pow(a:list[list[int]], m:int) -> list[list[int]]:
    if m == 0:
        return identity(len(a))
    if m % 2 > 0:
        return product(pow(a, m-1), a)
    half = pow(a, m//2)
    return product(half, half)

n,b = map(int,input().split())
a = [list(map(int,input().split())) for _ in range(n)]
for row in pow(a,b):
    print(*row)
