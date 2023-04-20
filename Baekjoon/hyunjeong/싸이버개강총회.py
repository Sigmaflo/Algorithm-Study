import sys


sys.stdin = open('싸이버개강총회.txt', 'r')
input = sys.stdin.readline

s, e, q = map(str, input().split())

enter = set([])
exit = set([])
count = 0

while True:
    temp = input().split()

    if not temp:
        break

    time, name = temp

    # if student commented on/before meeting
    if time <= s:
        enter.add(name)

    # if student commented on/after the meeting
    # and on/before the streaming ended
    elif time >= e and time <= q:
        if name in enter and name not in exit:
            exit.add(name)
            count += 1

    # if student commented after the streaming ended
    # irrelevant
    elif time > q:
        break

print(count)

