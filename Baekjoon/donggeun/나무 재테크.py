# n*n 크기의 땅
# m개의 나무
# 봄에는 자신의 나이만큼 양분을 섭취, 나이 1증가
# 자신이 위치한 곳의 양분만 섭취 가능하고, 여러 나무 있을시 어린놈부터 먹음. 먹지못하면 죽음
# 여름에는 죽은 나무가 양분으로 변함. 즉은 나무 나이 // 2
# 가을에는 번식. 5의 배수일 경우, 인접한 8개의 땅에 나이가 1인 나무가 생김
# 겨울에는 s2d2가 양분을 추가

from collections import defaultdict
import sys, heapq
input = sys.stdin.readline

dx = [0,1,-1,0,1,1,-1,-1]
dy = [1,0,0,-1,1,-1,1,-1]

def the_first_half():
    tmp = list(trees.keys())
    for y, x in tmp:
        new = []
        death = []
        breed_cnt = 0

        while trees[(y,x)]:
            age = heapq.heappop(trees[(y,x)])
            if now[y][x] >= age:
                now[y][x] -= age
                new.append(age+1)
                if (age+1)%5 == 0:
                    breed_cnt += 1
            else:
                death.append(age)
        
        # 나이먹은 나무 저장
        if new:
            trees.update({(y,x) : new})
        else:
            del trees[(y,x)]

        # 이 자리에서 번식가능한 나무의 갯수
        if breed_cnt:
            breeding.append([y, x, breed_cnt])

        # 여름, 
        for d in death:
            now[y][x] += d//2

def fall():
    for y,x,cnt in breeding:
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= n or ny >= n:
                continue
            for c in range(cnt):
                heapq.heappush(trees[(ny, nx)], 1)

    breeding.clear()


def winter():
    for y in range(n):
        for x in range(n):
            now[y][x] += foods[y][x]

n,m,k = map(int,input().split())
now = [[5]*n for _ in range(n)]
foods = [list(map(int,input().split())) for _ in range(n)]
trees = defaultdict(list)
breeding = []

for _ in range(m):
    y,x,z = map(int,input().split())
    heapq.heappush(trees[(y-1, x-1)], z)

for year in range(k):
    the_first_half()
    fall()
    winter()

ans = 0
for x in trees.values():
    ans += len(x)
print(ans)