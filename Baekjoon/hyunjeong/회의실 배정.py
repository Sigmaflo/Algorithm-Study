import sys
import heapq

# meetings = []
# n = map(int, sys.stdin.readline().split())
# for i in range(n):
#     a, b = map(int, sys.stdin.readline().split())
#     meetings.append((a, b))

#########TESTING###########
n = 11
meetings = [(1,4), (3,5), (0,6), (5,7), (3,8), (5,9), (6,10), (8,11), (8,12), (2,13), (12,14)]

sorted_intervals = sorted(meetings)
booked_rooms = []
for start, end in sorted_intervals:
    if booked_rooms and booked_rooms[0] <= start:
        heapq.heapreplace(booked_rooms, end)
    else:
        heapq.heappush(booked_rooms, end)
print(len(booked_rooms))


