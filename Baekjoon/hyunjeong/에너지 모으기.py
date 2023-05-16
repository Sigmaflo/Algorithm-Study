import sys


# sys.stdin = open('에너지 모으기.txt', 'r')
# input = sys.stdin.readline
n = int(input())
weights = [int(x) for x in input().split()]

def backtracking(e): 
    global answer
    if len(weights) == 2: 
        answer = max(answer, e)
        return

    for i in range(1, len(weights)-1):
        energy = weights[i-1] * weights[i+1]
        marble = weights.pop(i)
        backtracking(e + energy)
        weights.insert(i, marble)

selected = []
answer = 0
backtracking(0)
print(answer)