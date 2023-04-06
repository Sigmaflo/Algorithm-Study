from itertools import combinations
import sys


sys.stdin = open('링크와 스타트.txt', 'r')
input = sys.stdin.readline

n = int(input())
s = [list(map(int, input().split())) for _ in range(n)]
players = [x for x in range(n)]
valid_teams = []
for i in range(1, n):
    valid_teams.extend(list(combinations(players, i)))
# print(len(valid_teams))
# print(valid_teams)
res = float('inf')
for i in range(len(valid_teams)//2):
    team_1 = set(list(valid_teams[i]))
    team_2 = set(list(valid_teams[-i-1]))
    stat_1 = 0
    stat_2 = 0
    for j in range(n):
        for k in range(j+1, n):
            if j in team_1 and k in team_1:
                stat_1 += (s[j][k] + s[k][j])
            if j in team_2 and k in team_2:
                stat_2 += (s[j][k] + s[k][j])
    # stat_1 = sum(s[i][j] + s[j][i] for i in team_1 for j in team_1 if i != j)
    # stat_2 = sum(s[i][j] + s[j][i] for i in team_2 for j in team_2 if i != j)
    res = min(res, abs(stat_1 - stat_2))
print(res)

