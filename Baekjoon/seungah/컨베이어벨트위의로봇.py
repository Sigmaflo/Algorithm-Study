# [20055] 컨베이어 벨트 위의 로봇 (골드 5/시뮬레이션, 구현)

import sys
from collections import deque
input = sys.stdin.readline

N, K = map(int, input().split())
belt = deque(map(int, input().split()))

robot = deque(list([0]*N)) # 로봇은 N개

ans = 0

while True: ## K 이상이면 종료
    ## 벨트와 로봇 회전
    ans += 1
    belt.rotate(1)
    robot.rotate(1)
    robot[-1] = 0

    if sum(robot) > 0: # 로봇이 있는 경우
        for i in range(N-2, -1, -1): ## 로봇 한칸씩 이동 (오른쪽으로 이동)
            ## 자리에 로봇이 없고 벨트 내구도가 남아있으면 이동
            if robot[i] == 1 and robot[i+1] == 0 and belt[i+1]>=1:
                robot[i+1] = 1
                robot[i] = 0
                belt[i+1] -= 1
        
        ## 내리는 위치의 로봇은 즉시 내려져야 됨
        robot[-1] = 0
    ## 내구성 남아있으면 로봇 올리기 (idx 0)
    if robot[0] == 0 and belt[0] >= 1:
        robot[0] = 1
        belt[0] -= 1

    if belt.count(0) >= K:
        break

print(ans)
