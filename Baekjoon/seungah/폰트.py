# [9997] 폰트
import sys
input = sys.stdin.readline

# 만들 수 있는 테스트 문장의 개수 (테스트 문장은 알파벳 소문자 26개 전부 포함되어있어야 함)
answer = 0
def word_combine(vertex, sentence):
    if len(sentence) == 26:
        global answer
        answer += 2 ** (N - vertex -1)
        return
    if vertex>=0 and len(sentence)+word_len[vertex]<26:
        return
    if vertex==N-1:
        return
    word_combine(vertex+1, sentence | word_list[vertex]) # 단어 추가하는 경우
    word_combine(vertex+1, sentence) # 단어 추가하지 않는 경운

N = int(input().rstrip())
word_list = [set(input().rstrip()) for x in range(N)]
word_len = [len(sets) for sets in word_list]
for i in range(N-2, -1, -1):
    word_len[i] += word_len[i+1]

word_combine(-1, set())
print(answer)