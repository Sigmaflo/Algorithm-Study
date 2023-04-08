from collections import deque
import sys

# rotate wheel
def rotate_wheel(num, dir, wheels):
    if dir == -1:
        move = wheels[num].popleft()
        wheels[num].append(move)
    else:
        move = wheels[num].pop()
        wheels[num].appendleft(move)
    return wheels

# find what wheel to rotate next
def find_next(num, dir, stack, visited):
    if num == 0:
        if num+1 not in visited:
            stack.append((num+1, num, dir))
    elif num == 3:
        if num-1 not in visited:
            stack.append((num-1, num, dir))
    else:
        if num+1 not in visited:
            stack.append((num+1, num, dir))
        if num-1 not in visited:  
            stack.append((num-1, num, dir))
    return stack, visited

sys.stdin = open('톱니바퀴.txt', 'r')
input = sys.stdin.readline

wheels = [deque([]) for _ in range(4)]
print(wheels)
for i in range(4):
    wheels[i] = deque(list(map(int, input().strip())))

rotations = int(input())
for rotation in range(rotations):
    num, dir = map(int, input().split())
    num -= 1
    wheels = rotate_wheel(num, dir, wheels)
    stack = []
    visited = set([])
    visited.add(num)
    stack, visited = find_next(num, dir, stack, visited)
    while stack:
        now, past, dir = stack.pop()
        visited.add(now)
        if wheels[past][0] == wheels[now][0]:
            wheels = rotate_wheel(now, -dir, wheels)
        stack, visited = find_next(now, -dir, stack, visited)

# sum up the result
res = 0
for i in range(4):
    res += (2**i) * wheels[0][0]
print(res)
        

