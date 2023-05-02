def recursion(n:int, t:list[int]):
    if t[n] != 0:
        return t[n]

    tmp = 0
    for i in range(n):
        tmp += recursion(i,t) * recursion(n-i-1,t)
    t[n] = tmp
    return tmp

n = int(input())
t = [0]*(n+1)
t[0] = 1

print(recursion(n,t))