import heapq
INF = int(1e9)
graph = []
distance = []

def dijkstra(start):
    global distance
    heap = []
    heapq.heappush(heap, [0, start])
    distance[start] = 0
    
    while heap:
        cur_dist, cur = heapq.heappop(heap)
        if distance[cur] < cur_dist:
            continue
        for nxt, new_dist in graph[cur]:
            nxt_dist = new_dist + cur_dist
            if nxt_dist < distance[nxt]:
                distance[nxt] = nxt_dist
                heapq.heappush(heap,[nxt_dist, nxt])
    
        
def solution(N, road, K):
    global graph, distance
    
    answer = 0
    
    graph = [[] for _ in range(N+1)]
    for a,b,c in road:
        graph[a].append([b,c])
        graph[b].append([a,c])
    
    distance = [INF for _ in range(N+1)]
    dijkstra(1)
    for d in distance[1:]:
        if d<=K:
            answer +=1
            
    
    return answer