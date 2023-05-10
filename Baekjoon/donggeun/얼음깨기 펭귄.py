# 펭귄의 위치부터 bfs 탐색을 시작해서
# 지지대 얼음판까지의 거리를 알아낸다.
# 가장 짧은 거리의 얼음판 두 개랑 현재 팽귄의 얼음판만 안깨면 됨

from collections import deque
import sys
input = sys.stdin.readline

def bfs(st:int):
    queue = deque()
    queue.append((st, 0))
    visited = [False]*(n+1)
    visited[st] = True
    res = 0
    twice = False
    while queue:
        node, cnt = queue.popleft()

        if node <= s: # 지지대 얼음판에 도착
            res += cnt
            if not twice: # 첫번째라면
                twice = True
            else:
                return n - res - 1
        for nxt in tree[node]:
            if not visited[nxt]:
                queue.append((nxt, cnt+1))
                visited[nxt] = True
        

n,s,p = map(int,input().split())

tree = [[] for _ in range(n+1)]
for _ in range(n-1):
    a,b = map(int,input().split())
    tree[a].append(b)
    tree[b].append(a)

print(bfs(p))