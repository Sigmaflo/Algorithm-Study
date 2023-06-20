nums = [list(map(int,input().split())) for _ in range(4)]

for x1,y1,p1,q1,x2,y2,p2,q2 in nums:
    if (p1, y1) == (x2, q2) or (x1, y1) == (p2, q2) or (x1, q1) == (p2, y2) or (x2, y2) == (p1, q1):
        print("c")
    elif p1 < x2 or p2 < x1 or q1 < y2 or q2 < y1:
        print("d")
    elif (x2 == p1) or (x1 == p2) or (q1 == y2) or (q2 == y1):
        print("b")
    else:
        print("a")