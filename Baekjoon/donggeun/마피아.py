import sys
input = sys.stdin.readline

INF = -int(1e9)

def is_night(players: int) -> bool:
    return players % 2 == 0


n = int(input())
guilty = list(map(int,input().split()))

figure = [list(map(int,input().split())) for _ in range(n)]
mafia = int(input())
players = n
alives = [True]*n
day = 0

def change_guilty(guilty, x):
    for i in range(n):
        guilty[i] += figure[x][i]

    return guilty

def play(players, guilty, alives, day):
    while players > 0:
        if is_night(players):
            for x in range(n):
                if alives[x]: # 살아있다면 이녀석 kill
                    alives[x] = False
                    guilty = change_guilty(guilty, x)
                    play(players, guilty, alives, day+1)
                    alives[x] = True # like 재귀
            players -= 1
        else:
            target = guilty.index(max(guilty))
            alives[target] = False
            if target == mafia: # 은진이가 죽음
                return day
            guilty[target] = INF # 죽이기 유죄지수를 -INF 
            players -= 1
            # 죽이기
    return day
print(play(n, guilty, alives, day))