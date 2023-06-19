from sys import stdin
stdin= open("input.txt", "r")
input = stdin.readline

"""
1: 동쪽
2: 서쪽
3: 남쪽
4: 북쪽

4,2,3,1
"""
nxt = {1:4, 4:2, 2:3, 3:1}
length = {1:[], 2:[], 3:[], 4:[]}
k = int(input())
nums = [list(map(int,input().split())) for _ in range(6)]
nums.append(nums[0])
delete = []
way = []
for i in range(6):
    d,num = nums[i]
    length[d].append(num)
    if nxt[d] != nums[i+1][0]:
        delete.append(num)
        delete.append(nums[i+1][1])

print(length)
print(delete)
tmp = 1

for key in range(1,5):
    if len(length[key]) == 1:
        tmp *= length[key][0]

print((tmp - delete[0]*delete[1])*k)