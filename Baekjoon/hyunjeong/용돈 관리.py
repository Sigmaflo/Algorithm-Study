# import sys


# sys.stdin = open('용돈 관리.txt', 'r')
# input = sys.stdin.readline

n, m = map(int, input().split())
prices = []
for _ in range(n):
    prices.append(int(input()))

def try_k(k):
    count = 1
    cur_money = k
    for price in prices:
        if price > k:
            return False
        if price > cur_money:
            cur_money = k
            count += 1
        cur_money -= price

    return count <= m
        
l, r = min(prices), sum(prices)
while l <= r:
    mid = (l+r)//2

    if try_k(mid):
        answer = mid
        r = mid - 1
    else:
        l = mid + 1

print(answer)
    

