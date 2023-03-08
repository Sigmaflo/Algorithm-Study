import sys

t = map(int, sys.stdin.readline().split())

for i in range(t):
    n = map(int, sys.stdin.readline().split())
    phone_book = [] 
    for i in range(n):
        phone_book.append(input()) 
    phone_book.sort()
   

