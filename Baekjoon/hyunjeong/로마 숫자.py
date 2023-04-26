import sys


sys.stdin = open('로마 숫자.txt', 'r')
input = sys.stdin.readline

letter1 = input().strip()
letter2 = input().strip()

# conversions from letter to num and vice versa
letter_to_num = {'I':1, 'V':5, 'X':10, 'L':50, 'C':100, 'D':500, 'M':1000}
num_to_letter = {1:'I', 5:'V', 10:'X', 50:'L', 100:'C', 500:'D', 1000:'M'}

num1, num2 = 0, 0
# convert letter1 to num1
for i in range(len(letter1)):
    cur_letter = letter1[i]
    # for cases such as IV=4, IX=9, XL=40, XC=90, CD=400, CM=900
    if i > 0 and letter_to_num[letter1[i-1]] < letter_to_num[cur_letter]:
        num1 -= letter_to_num[letter1[i-1]]
        num1 += letter_to_num[cur_letter] - letter_to_num[letter1[i-1]]
    else:
        num1 += letter_to_num[cur_letter]

# convert letter2 to num2
for i in range(len(letter2)):
    cur_letter = letter2[i]
    # for cases such as IV=4, IX=9, XL=40, XC=90, CD=400, CM=900
    if i > 0 and letter_to_num[letter2[i-1]] < letter_to_num[cur_letter]:
        num2 -= letter_to_num[letter2[i-1]]
        num2 += letter_to_num[cur_letter] - letter_to_num[letter2[i-1]]
    else:
        num2 += letter_to_num[cur_letter]

num = num1 + num2
letter = ''
str_num = str(num)
d = len(str(num)) - 1
# convert num to letter
for i in range(len(str_num)):
    cur_num = int(str_num[i]) 
    digit = 10**d

    if cur_num <= 3:
        letter += str(cur_num * num_to_letter[digit])
    elif 3<cur_num<5:
        letter += str(num_to_letter[digit])
        letter += str(num_to_letter[digit*5])
    elif cur_num == 5:
        letter += str(num_to_letter[cur_num*digit])
    elif 5<cur_num<=8:
        letter += str(num_to_letter[digit*5])
        letter += str((cur_num - 5) * num_to_letter[digit])
    else:
        letter += str(num_to_letter[digit])
        letter += str(num_to_letter[digit*10])

    d -= 1

# print result
print(num)
print(letter)