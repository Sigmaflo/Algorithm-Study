import sys
input = sys.stdin.readline

word1 = input().rstrip()
word2 = input().rstrip()

n = len(word1)
m = len(word2)

word = [["" for _ in range(m+3)] for _ in range(n+3)]
for i in range(1,n+1):
    for j in range(1,m+1):
        if word1[i-1]==word2[j-1]:
            word[i][j] = word[i-1][j-1]+word1[i-1]
        
        else:
            if len(word[i-1][j]) > len(word[i][j-1]):
                word[i][j] = word[i-1][j]
            else:
                word[i][j] = word[i][j-1]
ans= word[n][m]
if len(ans):
    print(len(ans),ans,sep='\n')
else: print(0)