from collections import deque
import sys


sys.stdin = open('큐 2.txt', 'r')
input = sys.stdin.readline

n = int(input())
stack = deque([])
for _ in range(n):
    command = input().split()
    if command[0] == 'push':
        stack.append(int(command[1]))
    elif command[0] == 'pop':
        if stack:
            front = stack.popleft()
            print(front)
        else:
            print(-1)
    elif command[0] == 'size':
        print(len(stack))
    elif command[0] == 'empty':
        if stack:
            print(0)
        else:
            print(1)
    elif command[0] == 'front':
        if stack:
            print(stack[0])
        else:
            print(-1)
    else:
        if stack:
            print(stack[-1])
        else:
            print(-1)
