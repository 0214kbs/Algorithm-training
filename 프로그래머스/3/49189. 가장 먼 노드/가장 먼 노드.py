from collections import deque
def solution(n, edge):
    answer = 0
    graph = {i:[] for i in range(1,n+1)}
    for a,b in edge:
        graph[a].append(b)
        graph[b].append(a)
    
    depths = [0 for _ in range(n+1)]
    visited = [False for _ in range(n+1)]
    q = deque()
    q.append([1, 0]) # node, depth
    visited[1] = True
    
    max_v = 0
    while q:
        cur_n, cur_d = q.popleft()
        for nxt in graph[cur_n]:
            if not visited[nxt]:
                visited[nxt] = True
                depths[nxt] = cur_d+1
                max_v = max(max_v, cur_d+1)
                q.append([nxt, cur_d+1])
    for i in range(2, n+1):
        if max_v == depths[i]:
            answer += 1
    return answer