import sys
input = sys.stdin.readline

n,m = map(int,input().split())
graph = [list(map(int,input().rstrip())) for _ in range(n)]

def changed(n: int, m: int, graph: list[list[int]]) -> list[list[int]]:
    if n <= m:
        return n,m,graph
    res = [[0]*n for _ in range(m)]
    for i in range(n):
        for j in range(m):
            res[j][i] = graph[i][j]
    return m,n,res

# n이 더 작은 쪽으로 변경
n,m,graph = changed(n,m,graph)
ans = []
def bitmask():
    for i in range(1<<n*m):
        total=0
        for row in range(n):
            rowsum=0
            for col in range(m):
                idx=row*m+col
                if i&(1<<idx) != 0:
                    rowsum=rowsum*10+graph[row][col]
                else:
                    total+=rowsum
                    rowsum=0
            total+=rowsum

        for col in range(m):
            colsum=0
            for row in range(n):
                idx=row*m+col
                if i&(1<<idx)==0:
                    colsum=colsum*10+graph[row][col]
                else:
                    total+=colsum
                    colsum=0
            total+=colsum
        ans.append(total)

bitmask()

print(1<<n*m)
print(ans)
print(max(ans))
