import sys,heapq
input = sys.stdin.readline

n = int(input())
cards = [int(input()) for _ in range(n)]

res = 0
heapq.heapify(cards)
while len(cards)>1:
    a = heapq.heappop(cards)
    b = heapq.heappop(cards)
    res += a+b
    heapq.heappush(cards,a+b)
print(res)