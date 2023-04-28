import sys


# sys.stdin = open('문자열 게임 2.txt', 'r')
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    w = input().strip()
    k = int(input())

    count = {}
    shortest = 1e9
    longest = 0

    for i in range(len(w)):
        if w[i] not in count:
            count[w[i]] = []
        count[w[i]].append(i)

        # if found new substring where w[i] appears k times
        if len(count[w[i]]) == k:
            front = count[w[i]][0]
            back = count[w[i]][k-1]

            # update shortest
            if shortest > back-front+1:
                shortest = back-front+1
            # update longest
            if longest < back-front+1:
                longest = back-front+1
            
            # pop first element 
            count[w[i]].pop(0)
    
    # if shortest and longest has been found, print result
    if shortest != 1e9 and longest != 0:
        print(shortest, longest)
    else:
        print(-1)
