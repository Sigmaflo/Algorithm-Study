## 9252 LCS 2
 
str1 = input()
str2 = input()
str1 = '0'+str1
str2 = '0'+str2

lis = [['']*len(str2) for _ in range(len(str1))] ## Index Error 조심...
for i in range(1, len(str1)):
    tmp =''
    m = str1[i]
    for j in range(1, len(str2)):
        n = str2[j]
        lis[i][j] = lis[i-1][j-1]
        if len(lis[i-1][j-1]) <= len(lis[i-1][j]):
            lis[i][j] = lis[i-1][j]
        if m == n:
            tmp = lis[i-1][j-1] + m
        if len(lis[i][j]) < len(tmp):
            lis[i][j] = tmp
# 

# for m in range(len(str1)):
#     for n in range(len(str2)):
#         print(lis[m][n], end=' ')
#     print()

lcs = lis[-1][-1]
print(len(lcs))
if len(lcs) != 0:
    print(lcs)