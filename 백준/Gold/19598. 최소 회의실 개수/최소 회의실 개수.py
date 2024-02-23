import sys, heapq

input = sys.stdin.readline

n = int(input())
times = []
for i in range(n):
    s,e = map(int, input().split())
    times.append([s,e])

times.sort()

room = []
heapq.heappush(room, times[0][1]) # 종료 시간 넣기

for i in range(1,n):
    if times[i][0] < room[0]:
        heapq.heappush(room, times[i][1])
    else:
        heapq.heappop(room)
        heapq.heappush(room, times[i][1])

print(len(room))