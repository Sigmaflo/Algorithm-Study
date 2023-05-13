import math

def bt(s: list[int], visited: list[bool]):
    if len(s) == n:
        tmp = tuple([char[i] for i in s])
        if tmp not in arr:
            lucky(tmp)
            arr.add(tmp)
        return
    for i in range(n):
        if not visited[i] and (not s or char[s[-1]] != char[i]):
            visited[i] = True
            s.append(i)
            bt(s, visited)
            s.pop()
            visited[i] = False

def lucky(s: tuple[str]):
    global ans
    for i in range(len(s)-1):
        if s[i] == s[i+1]:
            return
    ans += 1
    return

char = list(input())
if len(set(char)) == len(char):
    print(math.factorial(len(char)))
else:
    n = len(char)
    arr = set()
    ans = 0
    bt([], [False]*n)
    print(ans)
