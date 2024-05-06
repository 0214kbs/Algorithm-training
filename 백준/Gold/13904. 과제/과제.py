import sys,heapq
input = sys.stdin.readline

N = int(input())
hq = []
max_day = 0
for i in range(N):
    d, w = map(int, input().split())
    heapq.heappush(hq, (-w, d))
    if max_day < d:
        max_day = d

assigned = [False] * (max_day + 1)

score = 0
while hq:
    w, d = heapq.heappop(hq)
    w = -w

    for i in range(d, 0, -1):
        if assigned[i]:
            continue

        assigned[i] = True
        score += w
        break

print(score)