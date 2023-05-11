import sys, re
input = sys.stdin.readline
res = []
p = re.compile('(100+1+|01)+')

for _ in range(int(input())):
    s = input().rstrip()
    m = p.fullmatch(s)
    res.append("YES" if m else "NO")

print(*res, sep='\n')