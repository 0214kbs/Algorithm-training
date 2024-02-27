import sys,heapq
input = sys.stdin.readline
n = int(input())
left_heap = []
right_heap = []

for i in range(n):
    num = int(input())
    if len(left_heap) == len(right_heap):
        heapq.heappush(left_heap, -num)
    else:
        heapq.heappush(right_heap,num)

    if right_heap and right_heap[0] < -left_heap[0]:
        left_v = heapq.heappop(left_heap)
        right_v = heapq.heappop(right_heap)

        heapq.heappush(left_heap,-right_v)
        heapq.heappush(right_heap,-left_v)
    # print(left_heap)
    # print(right_heap)
    print(-left_heap[0])