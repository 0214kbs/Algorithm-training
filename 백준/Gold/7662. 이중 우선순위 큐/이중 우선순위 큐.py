import sys, heapq
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    n = int(input())
    heap = []
    max_heap = []
    check = [True]*n
    for i in range(n):
        order,str_num = input().split()
        num = int(str_num)
        if order == 'I':
            heapq.heappush(heap, (num,i))
            heapq.heappush(max_heap, (-num,i))
        else:
            if len(heap) == 0:
                pass
            else:
                if num == 1:
                    tmp = heapq.heappop(max_heap)[1]
                    check[tmp] = False
                else:
                    tmp = heapq.heappop(heap)[1]
                    check[tmp] = False
        while heap and not check[heap[0][1]]:
            heapq.heappop(heap)
        while max_heap and not check[max_heap[0][1]]:
            heapq.heappop(max_heap)

    if heap:
        min_v = heapq.heappop(heap)[0]
        max_v = heapq.heappop(max_heap)[0]
        print(-max_v, min_v)
    else:
        print('EMPTY')