import sys,heapq
input = sys.stdin.readline

N = int(input())
univ = []
max_d = 0
for _ in range(N):
    p, d = map(int, input().split())
    max_d = max(d,max_d)
    heapq.heappush(univ, [-d,p])

pay = 0
heap = []
for day in range(max_d, 0,-1):
    # print(day, univ)
    while univ and -univ[0][0] >= day:
        d,p = heapq.heappop(univ)
        heapq.heappush(heap,[-p,-d])
    if not heap:
        if not univ:
            break
        else:
            day = -univ[0][0]
    else:
        p, d = heapq.heappop(heap)
        pay+= -p
        # print(d, -p)
print(pay)