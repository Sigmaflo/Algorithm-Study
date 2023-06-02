from collections import deque
import sys


sys.stdin = open('여행 가자.txt', 'r')
input = sys.stdin.readline

n = int(input())
m = int(input())
graph = []
for _ in range(n):
    graph.append(list(map(int, input().split())))
travel_plan = list(map(int, input().split()))

def reached_city(city, plan):
    if city == plan[0]:
        return True
    return False

def dfs(stack):
    # for i in range(graph[plan[0]]):
    #     if graph[plan[0]][i] == 1:
    #         stack.append(())
    duplicate_route = set([])
    while stack:
        cur_node, plan = stack.pop()
        if not plan:
            return 'True'
        for i in range(n):
            if graph[cur_node][i] == 1:
                print(plan)
                new_plan = plan.copy()
                if reached_city(i, plan):
                    new_plan.popleft()
                stack.append((i, new_plan))
                # duplicate_route.add((cur_node, i))
    return False             

stack = []
stack.append((travel_plan[0], deque(travel_plan)))        
if dfs(stack):
    print('YES')
else:
    print('NO')