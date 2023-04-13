import sys


sys.stdin = open('블로그.txt', 'r')
input = sys.stdin.readline

n, x = map(int, input().split())
visits = [int(x) for x in input().split()]

# create dp list to store sums of x days
dp = [0] * (n)
dp[0] = visits[0]

res = 0
count = 0
for i in range(1, len(visits)):
    # remove (i-x)-th element and add i-th element if over x days
    if (i + 1) > x:
        dp[i] = dp[i-1] - visits[i-x] + visits[i]
    # add i-th element 
    else:
        dp[i] = dp[i-1] + visits[i]
    
    # if equal to or more than x days, update largest number of visits
    if (i+1) >= x:
        if dp[i] == res:
            count += 1
        elif dp[i] > res:
            res = dp[i]
            count = 1
        else: 
            continue

# print result
if res == 0:
    print('SAD')
else:
    print(res)
    print(count)


