import sys


sys.stdin = open('가희와 키워드.txt', 'r')
input = sys.stdin.readline

n, m = map(int, input().split())
keywords = set([input().strip() for _ in range(n)])

for _ in range(m):
    used_keywords = input().rstrip().split(',')
    removed = 0
    for used_keyword in used_keywords:
        if used_keyword in keywords:
            keywords.remove(used_keyword)
            removed += 1

    print(len(keywords))

# time complexity: O(m)
# space complexity: O(n)
