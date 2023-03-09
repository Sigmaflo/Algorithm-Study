import sys
input = sys.stdin.readline

n = int(input())
problem = []
time = [[] for _ in range(n)]
for i in range(n):
    query = list(map(str,input().rstrip().split()))
    if query[0] == 'a':
        problem.append(int(query[1]))
    elif query[0] == 't':
        problem = time[int(query[1])-2][::]
    elif problem:
        problem.pop()
    time[i] = problem[::]
    print(problem[-1] if problem else -1)