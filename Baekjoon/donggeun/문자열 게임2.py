import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    w = input().rstrip()
    k = int(input())
    n = len(w)
    word = [[] for _ in range(26)]
    for i in range(n):
        word[ord(w[i])-97].append(i)
    res = []
    for val in word:
        if len(val) < k:
            continue
        for i in range(len(val)-k+1):
            res.append(val[i+k-1] - val[i]+1)
    print(f"{min(res)} {max(res)}" if res else -1)