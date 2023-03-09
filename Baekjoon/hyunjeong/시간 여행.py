import sys
# sys.stdin = open('시간 여행.txt', 'r')
input = sys.stdin.readline
n = int(sys.stdin.readline())

queries = []
for i in range(n):
    temp = sys.stdin.readline()
    queries.append(temp)

log = [[] for i in range(n)]
stack = []

for i in range(len(queries)):
    c = queries[i][0]
    if c == "a":
        stack.append(int(queries[i][2:]))
    elif c == "t":
        index = int(queries[i][2:]) - 2
        if index == -1 or index - 2 > i:
            stack = []
        else:
            stack = log[index][:]
        # stack = log[index]
    else:
        stack.pop()

    log[i] = stack[:]
    if stack:
        print(stack[-1])
    else:
        print(-1)
# print(log)

