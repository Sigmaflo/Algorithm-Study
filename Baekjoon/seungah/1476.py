# [1476] 날짜 계산

# 지구 E, 태양 S, 달 M
## 1 <= E <= 15
## 1 <= S <= 28
## 1 <= M <= 19

## 1년 증가할 때마다 세 수 모두 1씩 증가

import sys
input = sys.stdin.readline

E, S, M = map(int, input().split())

e, s, m = 1, 1, 1
year = 1

while True:
    if e == E and s == S and m == M:
        break
    e += 1
    s += 1
    m += 1

    if e == 16:
        e = 1
    if s == 29:
        s = 1
    if m == 20:
        m = 1
    year += 1


print(year)