# [16942] 문자열 접기 (골드 3)
S = input()
# https://www.singun11.wtf/posts/boj-16942/ 참고
D = [0]*1100
N = len(S)

for i in range(N):
    D[i] = 1

for i in range(1, N):
    for j in range(0, i):
        if (i-j)%2==1 and S[i]==S[j]:
            D[i] = max(D[i], D[j]+1)

ans = 0
for i in range(N):
    ans =max(D[i], ans)

print(ans)