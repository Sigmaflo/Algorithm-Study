import sys
input = sys.stdin.readline

# end = int(1e6)
end = 30
n,k = map(int,input().split())
arr = [0]*(end+1)
for _ in range(n):
    g,x = map(int,input().split())
    arr[x] = g
ans = []

ice = sum(arr[:2*k+1])
ans.append(ice)
print("시작", ice)
i = 0
for j in range(2*k+1, end+1):
    print("i", i, "j", j)
    ice = ice-arr[i]+arr[j]
    ans.append(ice)
    i += 1
print(max(ans))