from collections import deque
import sys


# sys.stdin = open('카드 문자열.txt', 'r')
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    cards = deque([x for x in input().split()])

    res = deque([])
    while cards:
        card = cards.popleft()
        if not res:
            res.append(card)
        else:
            # compare front with card
            front = res.popleft()
            
            # if card is less than or equal to front, insert to left
            if card <= front:
                res.appendleft(front)
                res.appendleft(card)
            # else insert to right
            else:
                res.appendleft(front)
                res.append(card)

    print(''.join(res))


