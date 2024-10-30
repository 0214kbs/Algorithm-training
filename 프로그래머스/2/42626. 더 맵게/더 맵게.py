import heapq
def solution(scoville, K):
    answer = 0
    
    heapq.heapify(scoville)
    while True:
        a = heapq.heappop(scoville)
        if a >= K:
            return answer
        if len(scoville) == 0:
            return -1
        b = heapq.heappop(scoville)
        nxt = a+b*2
        heapq.heappush(scoville, nxt)
        answer += 1
    return -1