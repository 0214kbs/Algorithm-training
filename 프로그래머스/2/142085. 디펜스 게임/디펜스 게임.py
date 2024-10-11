import heapq
def solution(n, k, enemy):
    if len(enemy) <= k:
        return len(enemy)
    
    heap = []
    for i in range(len(enemy)):
        heapq.heappush(heap, enemy[i])
        
        if len(heap)>k:
            n -= heapq.heappop(heap)
            if n <0:
                return i
            elif n == 0:
                return i+1
            
    return len(enemy)