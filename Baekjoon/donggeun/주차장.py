from collections import deque
import sys
input = sys.stdin.readline

def is_empty():
    return sum(parking) < n

def is_entrance(car):
    return car > 0


def park():
    for i in range(n):
        if not parking[i]:
            return i
    return None

n,m = map(int,input().split()) # 주차 공간, 차량의 수
pay = [int(input()) for _ in range(n)]
weight = [int(input()) for _ in range(m)]

parking = [0]*n
wait = deque()
now = dict()
ans = 0

for _ in range(2*m):
    i = int(input())
    if is_entrance(i): # 새로 주차
        if is_empty(): # 빈주차장이 존재
            place = park()
            ans += pay[place] * weight[i-1]
            parking[place] = 1
            now[i-1] = place # 주차한 곳 저장
        else: # 대기
            wait.append(i-1)
    else: # 나가는 차
        parking[now[-i-1]] = 0
        del now[-i-1]
        # 대기 차량이 있다면
        if wait:
            new = wait.popleft()
            place = park()
            ans += pay[place] * weight[new]
            parking[place] = 1
            now[new] = place
print(ans)