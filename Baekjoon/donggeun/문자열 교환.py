s = input()
a = s.count("a")
s += s[:-1]
n = len(s)
print(min([s[i:i+a].count("b") for i in range(n-a+1)]))