import sys


sys.stdin = open('주유소.txt', 'r')
input = sys.stdin.readline

n = int(input())
roads = [int(x) for x in input().split()]
gas_prices = [int(x) for x in input().split()]

res = 0
min_price = gas_prices[0]
# disregard prices[-1]
for i in range(n-1):
    # if current price is less than min_price, use current price to fill up gas
    # if current price is more than min_price, use min_price to fill up gas
    min_price = min(min_price, gas_prices[i])

    # update cumuluated price
    res += (min_price * roads[i])

print(res)




