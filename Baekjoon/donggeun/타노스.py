# 사전 순으로 제일 앞에 가려면
# 0은 뒤에서 부터 제거, 1은 앞에서 부터 제거

s = input()
zero_cnt = s.count("0")//2
one_cnt = s.count("1")//2

res = []

for idx,c in enumerate(s):
    if c == "0":
        continue
    if one_cnt > 0:
        one_cnt -= 1
    else:
        res.append(idx)

for i in range(len(s)-1, -1, -1):
    if s[i] == "1":
        continue
    if zero_cnt > 0:
        zero_cnt -= 1
    else:
        res.append(i)
print("".join([s[i] for i in sorted(res)]))