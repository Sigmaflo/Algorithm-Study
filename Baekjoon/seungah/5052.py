# [5052] 전화번호 목록

import sys
input = sys.stdin.readline

# 전화번호 목록이 주어질 때, 이 목록이 일관성이 있는지 없는지를 구하기
## 일관성 유지하려면 한 번호 전체가 다른 번호의 접두어인 경우가 없어야 함

# 풀이
### Trie 자료구조 사용
class Node(object):
		def __init__(self, key, data=None):
				self.key = key
				self.data = data
				self.children = {}


class Trie(object):
    def __init__(self):
        self.head = Node(None)
  # 문자열 삽입
    def insert(self, string):
        curr_node = self.head
        # 삽입할 string 각각의 문자에 대해 자식 Node를 만들며 내려간다.
        for char in string:
            # 자식 Node들 중 같은 문자가 없으면 Node 새로 생성
            if char not in curr_node.children:
                curr_node.children[char] = Node(char)
            # 같은 문자가 있으면 노드를 따로 생성하지 않고, 해당 노드로 이동
            curr_node = curr_node.children[char]

        #문자열이 끝난 지점의 노드의 data값에 해당 문자열을 입력
        curr_node.data = string

    # 문자열이 존재하는지 search
    def search(self, string):
        #가장 아래에 있는 노드에서 부터 탐색 시작
        curr_node = self.head
        for char in string:
            if char in curr_node.children:
                curr_node = curr_node.children[char]

        #탐색이 끝난 후 마지막 노드에 children이 없으면 안겹침
        if curr_node.children:
              return False
        else: # 있으면 prefix 포함됨
              return True


tc = int(input())

while tc > 0:
    N = int(input()) # 번호 수
    calls = []
    trie = Trie()

    for _ in range(N):
        num = input().rstrip()
        calls.append(num)
        trie.insert(num)
    

    calls.sort()
    flag = True

    for num in calls:
        if not trie.search(num): # 포함되면
             flag = False
             break


    if flag: # prefix 겹치지 않으면 YES
        print("YES")
    else: # prefix 겹치면 NO
        print("NO")
    
    tc -= 1
