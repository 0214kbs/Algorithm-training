import sys, heapq

input = sys.stdin.readline

n = int(input())
lectures = []

for _ in range(n):
    lectures.append(list(map(int, input().split())))

lectures.sort()

room = []
heapq.heappush(room,lectures[0][1])

for i in range(1,n):
    if lectures[i][0] < room[0]:
        heapq.heappush(room,lectures[i][1])
    else:
        heapq.heappop(room)
        heapq.heappush(room, lectures[i][1])

print(len(room))