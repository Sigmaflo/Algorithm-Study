import sys
input = sys.stdin.readline

INF = int(1e9)

def validate(value: int) -> bool:
    return abs(value) <= INF

def cal(first:int, second:int, div: bool) -> int:
    if div:
        return abs(second) // abs(first)
    return abs(second) % abs(first)

def sign(first:int, second:int, div: bool) -> int:
    if div:
        if first < 0 and second >= 0:
            return -1
        elif first >= 0 and second < 0:
            return -1
        else:
            return 1
    return -1 if second < 0 else 1


def command(cmd_list: list[str], nums: list[int]):
    res = []

    for num in nums:
        stk = [num]
        error = False

        for cmd in cmd_list:
            if cmd == "POP":
                if stk:
                    stk.pop()
                else: # 스택 비었는데 pop 수행 오류
                    error = True
                    break
            elif cmd == "INV":
                if stk:
                    head = stk.pop()
                    stk.append(-head)
                else:
                    error = True
                    break
            elif cmd == "DUP":
                if stk:
                    stk.append(stk[-1])
                else:
                    error = True
                    break
            elif cmd == "SWP":
                if len(stk) > 1:
                    first = stk.pop()
                    second = stk.pop()
                    stk.append(first)
                    stk.append(second)
                else:
                    error = True
                    break
            elif cmd == "ADD":
                if len(stk) > 1:
                    first = stk.pop()
                    second = stk.pop()
                    stk.append(first+second)
                else:
                    error = True
                    break
            elif cmd == "SUB":
                if len(stk) > 1:
                    first = stk.pop()
                    second = stk.pop()
                    stk.append(second-first)
                else:
                    error = True
                    break
            elif cmd == "MUL":
                if len(stk) > 1:
                    first = stk.pop()
                    second = stk.pop()
                    stk.append(second*first)
                else:
                    error = True
                    break
            elif cmd == "DIV":
                if len(stk) > 1 and stk[-1] != 0:
                    first = stk.pop()
                    second = stk.pop()
                    stk.append(sign(first, second, True) * cal(first, second, True))
                else:
                    error = True
                    break
            elif cmd == "MOD":
                if len(stk) > 1 and stk[-1] != 0:
                    first = stk.pop()
                    second = stk.pop()
                    stk.append(sign(first, second, False) * cal(first, second, False))
                else:
                    error = True
                    break
            else:
                stk.append(int(cmd[4:]))
            
            # 연산 한번 하고 값 확인
            if stk:
                if not validate(stk[-1]):
                    error = True
                    break

        if error:
            res.append("ERROR")
        elif len(stk) == 1:
            res.append(stk.pop())
        else:
            res.append("ERROR")
    return res

def print_ans(ans:list[int]):
    print(*ans[0], sep='\n')
    for x in ans[1:]:
        print()
        print(*x, sep='\n')


ans = []
while True:
    cmd_list = []
    while True:
        cmd = input().rstrip()
        if cmd == "END":
            n = int(input()) #프로그램 수행 횟수
            nums = [int(input()) for _ in range(n)]
            input().rstrip()
            break
        elif cmd == "QUIT":
            print_ans(ans)
            exit()
        else:
            cmd_list.append(cmd)
    
    ans.append(command(cmd_list, nums))


