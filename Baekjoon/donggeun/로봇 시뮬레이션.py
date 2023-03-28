import sys
input = sys.stdin.readline

a,b = map(int,input().split()) # 가로 세로
n,m = map(int,input().split()) # 로봇 개수, 명령 개수
robot = dict()
board = [[0]*a for _ in range(b)]
way = {"E": (0, 1), "W": (0, -1), "S":(1, 0), "N": (-1, 0)}
tmp = ["N", "W", "S", "E"]

def turn(left: bool, num: int, cnt: int):
    now = robot[num][2] # 현재 방향
    if left:
        robot[num] = (robot[num][0], robot[num][1], tmp[(tmp.index(now) + cnt)%4])
    else:
        robot[num] = (robot[num][0], robot[num][1], tmp[(tmp.index(now) - cnt)%4])        

def move(num:int, ny: int ,nx: int, z: str, cnt: int):
    dy,dx = way[z]
    board[ny][nx] = 0
    while cnt:
        nx, ny = nx + dx, ny + dy
        # 범위 밖
        if nx < 0 or ny < 0 or nx >= a or ny >= b:
            return f"Robot {num} crashes into the wall"
        # 보드가 0이 아님
        if board[ny][nx]:
            return f"Robot {num} crashes into robot {board[ny][nx]}"
        cnt -= 1
    board[ny][nx] = num
    robot[num] = (ny, nx, z)
    return "OK"

for i in range(1,n+1):
    # num: x,y,z 좌표, 방향
    x,y,z = map(str,input().rstrip().split())
    x,y = int(x)-1, b - int(y)
    board[y][x] = i # board에 i 번째 로봇이 있음
    robot[i] = (y,x,z) # i번째 로봇의 방향

for i in range(m):
    num,cmd,cnt = map(str,input().rstrip().split()) # 로봇, 명령, 횟수
    num, cnt = int(num), int(cnt)
    if cmd == "F":
        state = move(num, robot[num][0],robot[num][1], robot[num][2], cnt)
        if state != "OK":
            print(state)
            break
    elif cmd == "L":
        turn(True, num, cnt)
    else:
        turn(False, num, cnt)
else:
    print("OK")