# 가짓수가 많은 곳부터 방문인가?

import heapq

def search():
    hq = []
    pre = 1
    tmp = [[-len(tree[st]), st] for st in tree[0]]
    tmp.sort(key=lambda x:(x[0]))

    for i,j in tmp:
        heapq.heappush(hq, [i, j, pre])
        visited[j] = pre
        pre += 1

    while hq:
        cnt, node, time = heapq.heappop(hq)
        print("node", node, "time", time)
        for nxt in tree[node]:
            visited[nxt] = time + 1
            heapq.heappush(hq, [-len(tree[nxt]), nxt, time + 1])
    return max(visited)

n = int(input())
nums = list(map(int,input().split()))

tree = [[] for _ in range(n)]
visited = [0]*(n)

for idx, num in enumerate(nums[1:], 1):
    tree[num].append(idx)

print(search())