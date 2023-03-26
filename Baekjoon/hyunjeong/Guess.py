import sys

sys.stdin = open('Guess.txt', 'r')
input = sys.stdin.readline

n = int(input())
matrix = []
in_string = input()
index = n
while n > 0:
    matrix.append(in_string[:n])
    in_string = in_string[n:]
    n -= 1

print(matrix)
