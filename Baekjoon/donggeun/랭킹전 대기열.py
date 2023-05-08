import sys
input = sys.stdin.readline

p,m = map(int,input().split())
room = dict()

room = []

for _ in range(p):
    l,n = map(str,input().rstrip().split())
    l = int(l)

    for i in range(len(room)):
        if (room[i][0][0] - 10 <= l <= room[i][0][0] + 10) and len(room[i]) < m:
            room[i].append((l,n))
            break
    else:
        room.append([(l,n)])


for val in room:
    if len(val) == m:
        print("Started!")
    else:
        print("Waiting!")
    
    for ans in sorted(val, key=lambda x:x[1]):
        print(*ans)