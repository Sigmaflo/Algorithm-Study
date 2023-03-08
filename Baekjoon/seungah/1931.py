# [1931] 회의실 배정

import sys
input = sys.stdin.readline

N = int(input())
meeting = []
for i in range(N):
    a, b = map(int, input().split())
    meeting.append([a, b])

meeting = sorted(meeting, key=lambda x:(x[1], x[0]))
# print(meeting)

## 그리디
end = meeting[0][1] # 첫번째로 가장 빨리 끝나는 회의의 종료 시간
answer = 1

for i in range(1, N):
    start = meeting[i][0]
    if start >= end:
        answer += 1
        end = meeting[i][1]

print(answer)