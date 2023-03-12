import itertools

n = int(input())
words = [input() for i in range(n)]

permutations = list(itertools.permutations(words))

test_sentences = 0
for p in permutations:
    sentence = "".join(p)
    
print(test_sentences)
