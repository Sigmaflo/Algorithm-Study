from collections import deque
import sys

sys.stdin = open('에디터.txt', 'r')
input = sys.stdin.readline

# letters1 = letters on left side of cursor
# letters2 = letters on right side of cursor
letters1 = deque(list(input()[:-1])) 
letters2 = deque([])

m = int(input())
commands = [input().split() for _ in range(m)]

for i in range(m):
    # move cursor to left
    if commands[i][0] == "L":
        if letters1:
            letters2.appendleft(letters1.pop())

    # move cursor to right
    elif commands[i][0] == "D":
        if letters2:
            letters1.append(letters2.popleft())
    
    # remove letter at left of cursor
    elif commands[i][0] == "B":
        if letters1:
            letters1.pop()

    # add letter to left of cursor
    else:
        letters1.append(commands[i][1])

print("".join(letters1) + "".join(letters2))





