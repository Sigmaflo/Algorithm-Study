import heapq

N, K = map(int, input().split())
checkpoints = [tuple(map(int, input().split())) for _ in range(N)]

graph = [[] for _ in range(N)]
for i in range(N):
    for j in range(i+1, N):
        dist = abs(checkpoints[i][0]-checkpoints[j][0]) + abs(checkpoints[i][1]-checkpoints[j][1])
        graph[i].append((j, dist))
        graph[j].append((i, dist))

distances = [float('inf') for _ in range(N)]
distances[0] = 0

q = [(0, 0, 0)]  # (distance, current node, number of skipped checkpoints)
while q:
    dist, node, skips = heapq.heappop(q)
    if dist > distances[node]:
        continue
    if node == N-1:
        print(dist)
        break
    for neighbor, weight in graph[node]:
        if skips + (neighbor-node-1) > K:  # cannot skip more than K checkpoints
            continue
        new_dist = dist + weight
        if new_dist < distances[neighbor]:
            distances[neighbor] = new_dist
            heapq.heappush(q, (new_dist, neighbor, skips + (neighbor-node-1)))
