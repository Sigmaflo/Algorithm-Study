# [1474] 밑줄 (실버 1)
import sys
input = sys.stdin.readline
N, M = map(int, input().split())

alpha = []
alpha_len = 0
upper_idx = []
for i in range(N):
    tmp = input().strip()
    alpha_len += len(tmp)
    if str(tmp)[0].isupper():
        upper_idx.append(i)
    alpha.append(tmp)


under_len = len(alpha)-1
answer = alpha[0]

need_len = (M-alpha_len)//under_len
add_under = (M-alpha_len)%under_len
#print(add_under)
for idx in range(1, N):
    if str(alpha[idx])[0].islower() and add_under != 0:
        add_under -= 1
        answer += "_"*(need_len+1) + alpha[idx]
    elif idx + add_under == N:
        add_under -= 1
        answer += "_"*(need_len+1) + alpha[idx]
    else:
        answer+="_"*(need_len) + alpha[idx]

print(answer)

"""
4 30
Hello
world
John
said
"""


