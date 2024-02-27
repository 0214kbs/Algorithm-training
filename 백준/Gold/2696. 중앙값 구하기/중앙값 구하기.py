import sys, heapq
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    m = int(input())
    nums = [0]*m
    for i in range(m//10+1):
        input_tmp = list(map(int, input().split()))
        for j in range(len(input_tmp)):
            nums[i*10+j] = input_tmp[j]
    tmp = []
    left_heap = []
    right_heap = []
    for i in range(m):
        if len(left_heap) == len(right_heap):
            heapq.heappush(left_heap, -nums[i])
        else:
            heapq.heappush(right_heap, nums[i])

        if right_heap and right_heap[0] < -left_heap[0]:
            left = heapq.heappop(left_heap)
            right = heapq.heappop(right_heap)

            heapq.heappush(left_heap, -right)
            heapq.heappush(right_heap, -left)
        if i%2 == 0:
            tmp.append(-left_heap[0])
    print(len(tmp))
    for i in range(len(tmp)):
        if i != 0 and (i+1)%10 == 1:
            print()
        print(tmp[i], end=' ')
    print()