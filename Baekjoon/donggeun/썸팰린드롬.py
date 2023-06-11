n = 34
# n = int(input())
ans = (n//18)*2
mod = n%18

if not mod: pass
elif mod < 10: ans += 1
elif mod%2==0: ans += 2
else: ans += 3

print(ans)