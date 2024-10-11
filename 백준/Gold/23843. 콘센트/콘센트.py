import sys, heapq
input = sys.stdin.readline

N, M = map(int, input().split())
times = list(map(int, input().split()))
cons = []
last = []

if N <= M:
    print(max(times))
    sys.exit()

for t in times:
    heapq.heappush(last,-t)

for _ in range(M):
    t = heapq.heappop(last)
    heapq.heappush(cons, -t)


while last:
    curt = heapq.heappop(cons) # 양수
    addt = heapq.heappop(last)
    addt = -addt
    heapq.heappush(cons, curt+addt)
# print(cons)
print(max(cons))

