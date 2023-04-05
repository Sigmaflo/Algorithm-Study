import sys, math
input = sys.stdin.readline

def init(a, tree, node, start, end):
    if start == end:
        tree[node] = a[start]
    else:
        init(a, tree, node*2, start, (start+end)//2)
        init(a, tree, node*2+1, (start+end)//2+1, end)
        tree[node] = tree[node*2] * tree[node*2+1]

def update(a, tree, node, start, end, index, val):
    if index < start or index > end:
        return
    if start == end:
        a[index] = val
        tree[node] = val
        return
    update(a, tree, node*2, start, (start+end)//2, index, val)
    update(a, tree, node*2+1, (start+end)//2+1, end, index, val)
    tree[node] = tree[node*2] * tree[node*2+1]

def query(tree, node, start, end, left, right):
    if left > end or right < start:
        return 1
    if left <= start and end <= right:
        return tree[node]
    l_query = query(tree, node*2, start, (start+end)//2, left, right)
    r_query = query(tree, node*2+1, (start+end)//2+1, end, left, right)
    return l_query * r_query

while True:
    try:
        n,k = map(int,input().split())
        a = list(map(int,input().split()))
        for i in range(n):
            if a[i] > 0:
                a[i] = 1
            elif a[i] < 0:
                a[i] = -1

        h = math.ceil(math.log2(n))
        tree_size = 1 << (h+1)
        tree = [0] * tree_size
        init(a, tree, 1, 0, n-1)
        
        for _ in range(k):
            cmd, t1, t2 = map(str, input().rstrip().split())
            if cmd == "C": # update
                index, val = int(t1), int(t2)
                if val > 0:
                    val = 1
                elif val < 0:
                    val = -1
                update(a, tree, 1, 0, n-1, index-1, val)
                
            else:
                left, right = int(t1), int(t2)
                ans = query(tree, 1, 0, n-1, left-1, right-1)
                if ans > 0:
                    print('+',end='')
                elif ans < 0:
                    print('-', end='')
                else:
                    print('0', end='')
        print()
    except Exception:
        break
