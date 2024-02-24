import sys, heapq
input = sys.stdin.readline
n, m = map(int, input().split())
alist = list(map(int, input().split()))

heapq.heapify(alist)
for i in range(m):
    x = heapq.heappop(alist)
    y = heapq.heappop(alist)
    heapq.heappush(alist, x+y)
    heapq.heappush(alist, x+y)

print(sum(alist))