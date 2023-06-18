from sys import stdin
input = stdin.readline

def comb(s:list[int], visited:list[bool]) -> None:
    if len(s) == k:
        global candy
        candy.add("".join([str(nums[i]) for i in s]))
        return
    
    for i in range(n):
        if not visited[i]:
            s.append(i)
            visited[i] = True
            comb(s, visited)
            visited[i] = False
            s.pop()

n = int(input())
k = int(input())
nums = [int(input()) for _ in range(n)]
candy = set()
comb([], [False]*n)
print(len(candy))