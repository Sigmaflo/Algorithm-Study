a, b = map(int, input().split())
n, m = map(int, input().split())

robots = []
for i in range(n):
    x, y, direction = input().split()
    robots.append((int(x), int(y), direction))

dx = [-1, 0, 1, 0]  
dy = [0, 1, 0, -1]
directions = ['W', 'N', 'E', 'S']
crash_robot = None 
for i in range(m):