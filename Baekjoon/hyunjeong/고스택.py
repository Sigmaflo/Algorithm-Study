import sys
# sys.stdin = open('고스택.txt', 'r')
input = sys.stdin.readline
stack = []

while True:
    cmd = input().split()

    if cmd[0] == 'NUM':
        stack.append(int(cmd[1]))

    elif cmd[0] == 'POP':
        if not stack:
            print('ERROR')
            break
        stack.pop()

    elif cmd[0] == 'INV':
        if not stack:
            print('ERROR')
            break
        stack[-1] = -stack[-1]

    elif cmd[0] == 'DUP':
        if not stack:
            print('ERROR')
            break
        stack.append(stack[-1])

    elif cmd[0] == 'SWP':
        if len(stack) < 2:
            print('ERROR')
            break
        stack[-1], stack[-2] = stack[-2], stack[-1]

    elif cmd[0] == 'ADD':
        if len(stack) < 2:
            print('ERROR')
            break
        x = stack.pop()
        y = stack.pop()
        res = x + y
        if abs(res) > 10**9:
            print('ERROR')
            break
        stack.append(res)

    elif cmd[0] == 'SUB':
        if len(stack) < 2:
            print('ERROR')
            break
        x = stack.pop()
        y = stack.pop()
        res = y - x
        if abs(result) > 10**9:
            print('ERROR')
            break
        stack.append(res)

    elif cmd[0] == 'MUL':
        if len(stack) < 2:
            print('ERROR')
            break
        x = stack.pop()
        y = stack.pop()
        res = x * y
        if abs(res) > 10**9:
            print('ERROR')
            break
        stack.append(res)
    elif cmd[0] == 'DIV':
        if len(stack) < 2:
            print('ERROR')
            break
        x = stack.pop()
        y = stack.pop()
        res = y // x
        stack.append(res)
    elif cmd[0] == 'MOD':
        if len(stack) < 2:
            print('ERROR')
            break
        x = stack.pop()
        y = stack.pop()
        res = y % x
        stack.append(res)
    elif cmd[0] == 'QUIT':
        print("\n")
        break
    else:
        continue

           
