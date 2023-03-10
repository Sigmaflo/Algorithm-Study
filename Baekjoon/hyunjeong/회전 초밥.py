import sys
# sys.stdin = open('회전 초밥.txt', 'r')
input = sys.stdin.readline
n, d, k, c = map(int, input().split())
dishes = []
for i in range(n):
    dishes.append(int(input()))

# check for (duplicate) number of dishes
def check_seen(seen, i):
    if dishes[i] not in seen:
        seen[dishes[i]] = 0
    seen[dishes[i]] += 1
    return seen

k_dishes = []
seen = {}

# set k_dishes by pushing index o to k-1 from dishes
for i in range(k):
    k_dishes.append(dishes[i])
    seen = check_seen(seen, i)

# set res by calculating diff number of dishes
res = len(seen.keys())
if c not in seen.keys():
    res += 1

for x in range(k, n+k-1):
    i = x%n

    # setting k_dishes to represent the next k_dishes by pop and push
    top_dish = k_dishes.pop(0)
    seen[top_dish] -= 1
    if seen[top_dish] == 0:
        seen.pop(top_dish)

    k_dishes.append(dishes[i])
    seen = check_seen(seen, i)

    # calculate diff number of dishes
    temp_res = len(seen.keys())
    if c not in seen.keys():
        temp_res += 1

    res = max(res, temp_res)
print(res)



    

