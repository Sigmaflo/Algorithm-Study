from itertools import combinations
import sys


# calculate x, y in different cases
def calculate (x, y):
    if x < y:
        new_x = 2 * x
        new_y = y - x
    elif x > y:
        new_y = 2 * y
        new_x = x - y
    else:
        new_x = x
        new_y = y
    return new_x, new_y

sys.stdin = open('돌 그룹.txt', 'r')
input = sys.stdin.readline
a, b, c = map(int, input().split())

stack = ([])
stack.append((a, b, c))
visited = set([])
found = False
while stack:
    a, b, c = stack.pop()
    visited.add((a, b, c))

    if a == b == c:
        found = True
        break
    
    # operate on a, b 
    new_a, new_b = calculate(a, b)
    if (new_a, new_b, c) not in visited:
        stack.append((new_a, new_b, c))

    # operate on b, c
    new_b, new_c = calculate(b, c)
    if (a, new_b, new_c) not in visited:
        stack.append((a, new_b, new_c))

    # operate on a, c
    new_a, new_c = calculate(a, c)
    if (new_a, b, new_c) not in visited:
        stack.append((new_a, b, new_c))

if found:
    print(1)
else:
    print(0)