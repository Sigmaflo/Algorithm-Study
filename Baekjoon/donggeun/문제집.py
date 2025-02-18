import sys, heapq
input = sys.stdin.readline

def solve():
    n,m = map(int,input().split())
    edges = [0]*(n+1)
    graph = [[] for _ in range(n+1)]
    for _ in range(m):
        a,b = map(int,input().split())
        edges[b]+=1
        graph[a].append(b)
    topology(n, graph, edges)

def topology(n, graph, edges):
    ans = []
    h = []
    for i in range(1, n+1):
        if not edges[i]:
            heapq.heappush(h, i)

    while h:
        node = heapq.heappop(h)
        ans.append(node)
        for i in graph[node]:
            edges[i] -= 1
            if not edges[i]:
                heapq.heappush(h, i)
    print(*ans)

solve()