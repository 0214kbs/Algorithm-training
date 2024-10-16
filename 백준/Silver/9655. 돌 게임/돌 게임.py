import sys
input = sys.stdin.readline

n = int(input())

res = n//3
nxt = n%3

if (res+nxt)%2 == 0:
    print("CY")
else:
    print("SK")
