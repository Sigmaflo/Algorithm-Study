memo = {}  

def num_decodings(s):
    if s in memo:
        return memo[s]
    if len(s) == 0:
        return 1
    if s[0] == "0":
        return 0
    num_ways = num_decodings(s[1:])
    if len(s) >= 2 and int(s[:2]) <= 26:
        num_ways += num_decodings(s[2:])
    memo[s] = num_ways
    return num_ways

while True:
    s = input().strip()
    if s == "0":
        break
    print(num_decodings(s))
