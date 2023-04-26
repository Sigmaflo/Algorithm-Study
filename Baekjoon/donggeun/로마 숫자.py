rome = {"I":1, "V":5, "X":10, "L":50, "C":100, "D":500, "M":1000}

def rome_to_num(char: str) -> int:
    pre = char[0]
    res = 0
    for c in char:
        if rome[pre] < rome[c]:
            res += rome[c] - 2*rome[pre]
        else:
            res += rome[c]
            pre = c
    return res

def num_to_rome(nums:int) -> str:
    res = ""
    div = []

    for key,val in sorted(rome.items(), key=lambda x:-x[1]):
        div.append((key,nums//val))
        nums %= val

    idx = 0
    print(div)
    rome_keys = list(reversed(rome.keys()))

    for key, val in div:
        if val > 3:
            pre = res[-1] if res else ""
            if pre in {"V", "L", "D"} and rome_keys[idx-1] == pre: # 5짜리가 2개 있음 안되기 떔시
                res = res[:-1] + key + rome_keys[idx-2]
                # print("여기 옴?")

            else:
                res += key + rome_keys[idx-1] # 4개 이상시 작은거 + 큰거
        else:
            res += key*val
        
        idx += 1
    return res

char1 = input()
char2 = input()

ans = rome_to_num(char1) + rome_to_num(char2)
print(ans, num_to_rome(ans),sep='\n')
