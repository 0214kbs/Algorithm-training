import sys
from itertools import combinations
input = sys.stdin.readline

n = int(input())
alist = list(map(int, input().split()))
x = int(input())

alist.sort()

res = 0
start = 0
end = n-1
while True:
    if start >= end:
        break
    if alist[start]+alist[end] > x:
        end-=1
    elif alist[start]+alist[end] == x:
        end-=1
        start +=1
        res +=1
    else:
        start+=1

print(res)