text = list(map(str,input().split()))
first_type = text[0]
var_type = ["*", "[", "]", "&"]
var = []
ans = []

# print("data", text)

for data in text[1:]:
    # print("data", data)
    tmp = ""
    typ = ""
    for char in data[:-1]:
        if char.isalpha():
            tmp += char
        elif char == "[":
            typ += "]"
        elif char == "]":
            typ += "["
        else:
            typ += char
    ans.append([typ[::-1], tmp])

for typ, tmp in ans:
    print(first_type+typ, tmp+";")