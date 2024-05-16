import sys,heapq
input = sys.stdin.readline

N = int(input())
station = []
for _ in range(N):
    a,b = map(int, input().split())
    station.append([a,b])
L,P = map(int, input().split())
station.append([L,0])
station.sort()

heap = []
res = 0
for i in range(len(station)):
    if P - station[i][0] < 0:
        while heap:
            P += -heapq.heappop(heap)
            res += 1
            if P - station[i][0] >= 0:
                break
    if len(heap) == 0 and P - station[i][0] < 0:
        res = -1
        break
    else:
        heapq.heappush(heap,-station[i][1])

print(res)