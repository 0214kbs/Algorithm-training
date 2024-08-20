import sys,heapq
input = sys.stdin.readline

N = int(input())
left = []
right = []
for i in range(1,N+1):
    now = int(input())
    if len(left) == len(right):
        heapq.heappush(left, -now)
    else:
        heapq.heappush(right, now)

    if right and right[0]<-left[0]:
        left_max = heapq.heappop(left)
        right_min = heapq.heappop(right)
        heapq.heappush(right, -left_max)
        heapq.heappush(left, -right_min)

    print(-left[0])