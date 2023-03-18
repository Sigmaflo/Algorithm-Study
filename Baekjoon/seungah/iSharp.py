# [3568] iSharp (실버3)

x = input()
x_list = x.split(' ')
basic = x_list[0]

del x_list[0]
## 변수의 오른편에 있는 변수형은 순서를 뒤집어서 왼편에 붙일 수 있다. 

for s in x_list:
    s = s.replace(",","")
    s = s.replace(";","")
    print(basic, end='')

    for i in range(len(s)-1, 0, -1):
        if not s[i].isalpha():
            if s[i] == "]":
                print("[", end='')
            elif s[i]== "[":
                print("]", end='')
            else:
                print(s[i], end='')
    
    print(' ', end='')
    for i in range(len(s)):
        if s[i].isalpha():
            print(s[i], end='')
    
    print(';')

