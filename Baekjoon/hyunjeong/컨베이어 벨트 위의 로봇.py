import sys

input = sys.stdin.readline
N, K = map(int, input().split())
A = list(map(int, input().split()))

belt = [0] * (2 * N) 
robot = {} 
time = 0 

while True:
    time += 1   
    belt.insert(0, belt.pop())
    robot = {k+1 if k < 2*N-1 else 1: v for k, v in robot.items()}
    if N in robot:
        del robot[N]  
