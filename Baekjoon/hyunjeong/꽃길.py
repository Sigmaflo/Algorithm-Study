import sys


sys.stdin = open('꽃길.txt', 'r')
input = sys.stdin.readline

def check_prev_flowers(a, b):
    for xx, yy in list(zip(dx, dy)):
        new_x = a+xx
        new_y = b+yy
        if (new_x, new_y) in visited:
            return False
    return True

def dfs(cur):
    global total, answer
    if cur == 3:
        answer = min(answer, total)
        return
    for i in range(1, n-1):
        for j in range(1, n-1):
            if check_prev_flowers(i, j):
                for xx, yy in list(zip(dx, dy)):
                    new_x = i + xx
                    new_y = j + yy
                    visited.add((new_x, new_y))
                    total += garden_prices[new_x][new_y]
                dfs(cur + 1)
                for xx, yy in list(zip(dx, dy)):
                    new_x = i + xx
                    new_y = j + yy
                    visited.remove((new_x, new_y))
                    total -= garden_prices[new_x][new_y]

n = int(input())
garden_prices = []
for _ in range(n):
    garden_prices.append(list(map(int, input().split())))

dx = [0, -1, 1, 0, 0]
dy = [0, 0, 0, -1, 1]
visited = set([])
answer = 1e9
total = 0
dfs(0)
print(answer)
