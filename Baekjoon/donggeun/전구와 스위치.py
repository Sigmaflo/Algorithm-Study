n = int(input())
origin = list(map(int,input().rstrip()))
goal = list(map(int,input().rstrip()))

one_no_click = 0
new_arr = origin[:]

for i in range(1, n):
    if origin[i-1] != goal[i-1]:
        one_no_click += 1
        origin[i-1] ^= 1
        origin[i] ^= 1
        if i != n-1:
            origin[i+1] ^= 1


one_click = 1
new_arr[0] ^= 1
new_arr[1] ^= 1

for i in range(1, n):
    if new_arr[i-1] != goal[i-1]:
        one_click += 1
        new_arr[i-1] ^= 1
        new_arr[i] ^= 1
        if i != n-1:
            new_arr[i+1] ^= 1

if origin == goal == new_arr:
    print(min(one_click, one_no_click))
elif origin == goal:
    print(one_no_click)
elif new_arr == goal:
    print(one_click)
else:
    print(-1)

# print('origin',origin, "go", goal, "oneno", one_no_click)
# print('new', new_arr, "app", goal, "one", one_click)