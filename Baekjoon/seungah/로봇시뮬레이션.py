# [2174] 로봇 시뮬레이션
import sys
input = sys.stdin.readline
dist_dic = {
    "N":0,
    "E":1,
    "S":2,
    "W":3
}
dist = [[-1, 0], [0, 1], [1, 0], [0, -1]]

A, B = map(int, input().split())
N, M = map(int, input().split())

road = [[0]*A for _ in range(B)] # robots 위치
robots = [] # robots 정보
for i in range(N): # i:robot_idx
    X, Y, D = input().split() # 로봇
    r, c = B-int(Y), int(X)-1
    robots.append([r, c, dist_dic[D]])
    road[r][c] = 1

flag = False
for i in range(M): # 명령
    robot_idx, command, cnt = input().split()
    robot_idx = int(robot_idx)
    cnt = int(cnt)

    r, c, d = robots[robot_idx-1] # 로봇 정보 불러오기
    while cnt > 0:
        if command == "L":
            d -= 1
            if d < 0:
                d += 4
        elif command == "R":
            d += 1
            if d > 3:
                d -= 4
        else: # "F"
            break
        cnt-=1

    if command == "F":
        nr, nc = dist[d]
        nr, nc = nr+cnt, nc+cnt
        #print("nr",nr,"nc",nc)
        nx = r+nr
        ny = c+nc
        #print("nx",nx,"ny",ny)
        if not (0 <= nx < B) or not (0 <= ny < A):
            print("Robot", robot_idx, "crashes into the wall")
            flag = True
            break
        if 0<=nx<B and 0<=ny<A:
            if road[nx][ny] == 1:
                for a in range(len(robots)):
                    if nx == robots[a][0] and ny == robots[a][1]:
                        print("Robot",robot_idx,"crashed into robot",a)
                        flag = True
                        break

            road[nx][ny] = 1
            road[r][c] = 0
            robots[robot_idx-1] = nx, ny, d
    else:
        robots[robot_idx-1] = r, c, d
    
    if flag:
        break

if flag == False:
    print("OK")
