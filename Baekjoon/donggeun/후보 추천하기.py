from collections import defaultdict
n = int(input())
m = int(input())
nums = list(map(int,input().split()))

student = defaultdict(int)
order = defaultdict(int)
pic = set()

for i in range(m):

    if len(pic) < n or nums[i] in pic:
        if nums[i] not in pic:
            order[nums[i]] = i
        pic.add(nums[i])
        student[nums[i]] += 1
    else: # 빼야함
        tmp = [(student[t], order[t], t) for t in pic]
        tmp.sort()
        get_out = tmp[0][2]
        pic.remove(get_out)
        student[get_out] = 0
        order[get_out] = 0

        pic.add(nums[i])
        student[nums[i]] += 1
        order[nums[i]] = i

print(*sorted(pic))