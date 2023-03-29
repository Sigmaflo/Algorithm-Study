# [1406] 에디터 (실버 2)
import sys
input = sys.stdin.readline
from collections import deque
text1 = deque(list(input().rstrip()))
text2 = deque()

N = int(input())

for _ in range(N):
    command = input().rstrip().split()
    if command[0] == "L":
        if text1:
            text2.appendleft(text1.pop())
    elif command[0] == "D":
        if text2:
            text1.append(text2.popleft())
    elif command[0] == "B":
        if text1:
            text1.pop()
    else:
        text1.append(command[1])


text1.extend(text2)
print(''.join(text1))