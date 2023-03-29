words = input()
n = len(words)

# dp[n][m] 은 n 층 마지막 문자는 길이 m로 정의가 될거 같은데,,,
dp = [[1]*(n+1) for _ in range(n+1)] 

for i in range(n):
    for j in range(1,n):
        # dp[i][j] = words[]
        # print(words[:j], words[j:][::-1])
        v,w = len(words[j:]), len(words[:j])
        # print(v,w)
        # print(words[j:][::-1][::min(v,w)].rjust(n))
        # print(words[:j][:min(v,w)].rjust(n))
        # print()
        tmp = 0
        for k in range(min(v,w)):
            if words[j:][::-1][k] == words[:j]:
                tmp += 1
        dp[i][j] = tmp

print(max(map(max,dp)))
