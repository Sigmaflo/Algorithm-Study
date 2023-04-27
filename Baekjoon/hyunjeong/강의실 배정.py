import sys


sys.stdin = open('강의실 배정.txt', 'r')
input = sys.stdin.readline

n = int(input())
class_times = []
for _ in range(n):
    s, t = map(int, input().split())
    class_times.append((s, t))

class_times.sort(key = lambda a:(a[0], a[1]))
class_locs = []
start = class_times[0][0]
end = class_times[0][1]
print(class_times)
count = 0
for i in range(1, len(class_times)):
    s, t = class_times[i]
    if s >= end:
        # count doesn't increase
        end = t
    else:
        count += 1
        start = max(start, s)
        end = max(end, t)

print(count)
