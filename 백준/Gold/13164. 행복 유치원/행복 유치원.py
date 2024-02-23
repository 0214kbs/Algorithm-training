import sys
input = sys.stdin.readline

n,k = map(int, input().split())
heights = list(map(int, input().split()))

subs_h = []

for i in range(n-1):
    subs_h.append(heights[i+1]-heights[i])

subs_h.sort()

price = 0
for i in range(n-k):
    price += subs_h[i]

print(price)