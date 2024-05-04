import sys,heapq
input = sys.stdin.readline

weight = []
N = int(input())
chu = list(map(int, input().split()))
chu.sort()

check = 1
for c in chu:
    if check<c:
        break
    check += c
print(check)