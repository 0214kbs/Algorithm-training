import sys
from bisect import bisect_left,bisect_right
input = sys.stdin.readline

n = int(input())
cards = list(map(int,input().split()))

m = int(input())
nums = list(map(int,input().split()))

res = []

cards.sort()

def count(num):
    right = bisect_right(cards, num)
    left = bisect_left(cards, num)
    return right - left
for n in nums:
    res.append(count(n))

print(*res)