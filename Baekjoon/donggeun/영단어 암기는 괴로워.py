from collections import Counter
import sys
input = sys.stdin.readline

n, m = map(int,input().split())
words = list(Counter([input().rstrip() for _ in range(n)]).items())
words.sort(key=lambda x: (-x[1], -len(x[0]), x))
for word, cnt in words:
    if len(word) >= m:
        print(word)
