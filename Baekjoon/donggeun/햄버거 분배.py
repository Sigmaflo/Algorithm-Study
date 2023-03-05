import sys
input = sys.stdin.readline

n,k = map(int,input().split())
string = list(map(str,input().rstrip()))
people = []
hamburger = [False]*n
for i in range(n):
    if string[i] == "P":
        people.append(i)
    else:
        hamburger[i] = True

ans = 0
for p in people:
    for i in range(-k, k+1):
        if 0 <= i+p < n:
            if hamburger[i+p]:
                ans += 1
                hamburger[i+p] = False
                break
print(ans)
