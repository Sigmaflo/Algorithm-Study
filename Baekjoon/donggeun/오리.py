# 12933

sound = list(input())
quack = ["q","u","a","c","k","q"]
nxt = {quack[i]:quack[i+1] for i in range(5)}
cnt = []
fail = False
for s in sound:
    for i in range(len(cnt)):
        if nxt[cnt[i]] == s:
            cnt[i] = s
            break
    else:
        if s == "q":
            cnt.append(s)
        else:
            print(-1)
            exit()
print(len(cnt) if set(cnt) == {"k"} else -1)