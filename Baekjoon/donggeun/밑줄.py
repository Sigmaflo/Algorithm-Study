import sys
input = sys.stdin.readline

n,m = map(int,input().split())
pre = 0
words = []
for _ in range(n):
    word = input().rstrip()
    pre += len(word)
    words.append(word)
    words.append("")

words.pop() # 마지막 "" 제거
div = (m - pre) // (n-1)
mod = (m - pre) % (n-1)

for i in range(1, n*2-1, 2):
    if not mod:
        words[i] = "_"*(div)
    elif words[i+1][0].islower():
        words[i] = "_"*(div+1)
        mod -= 1
    elif words[i+1][0].isupper():
        if mod <= ((n * 2 - 1) - i) // 2 - 1: # 뒤에서 채워도 됨
            words[i] = "_"*(div)
        else:
            words[i] = "_"*(div+1) # 뒤에거 생각
            mod -= 1
print(*words, sep='')