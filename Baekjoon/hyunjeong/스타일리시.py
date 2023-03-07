def calculate(line, R, C, S, ro, rc, co, cc, so, sc):
    line_ro = line.count('(')
    line_rc = line.count(')')
    line_co = line.count('{')
    line_cc = line.count('}')
    line_so = line.count('[')
    line_sc = line.count(']')

    indent = R*(ro-rc) + C*(co-cc) + S*(so-sc)

    if ro+line_ro-rc != co+line_co-cc or ro+line_ro-rc != so+line_so-sc:
        return -1

    ro += line_ro
    rc += line_rc
    co += line_co
    cc += line_cc
    so += line_so
    sc += line_sc

    return indent


while True:
    p, q = map(int, input().split())

    if p == q == 0:
        break

    ro = rc = co = cc = so = sc = 0

    for i in range(p):
        line = input().strip()
        indent = calculate(line, R, C, S, ro, rc, co, cc, so, sc)
        if indent == -1:
            print(-1)
            break
        print(indent)
    else:
        for i in range(q):
            line = input().strip()
            indent = calculate(line, R, C, S, ro, rc, co, cc, so, sc)
            if indent == -1:
                print(-1)
                break
            print(indent, end=' ')
        else:
            print()
    print("\n")
