import sys
from collections import deque
input = sys.stdin.readline

def bfs(mid):
    q = deque()
    visited = [False for _ in range(N + 1)]
    visited[land1] = True
    q.append(land1)

    while q:
        cur = q.popleft()
        if cur == land2:  # 성공
            return True

        for nxt, value in graph[cur]:
            if not visited[nxt] and value >= mid:
                visited[nxt] = True
                q.append(nxt)
    return False


N, M = map(int, input().split())
graph = {i:[] for i in range(1,N+1)}

start, end = 1, 1000000000
for _ in range(M):
    a,b,c =map(int, input().split())
    graph[b].append([a,c])
    graph[a].append([b,c])

land1, land2 = map(int, input().split())
# print(start, end)
res = 0
while start <= end:
    mid = (start+end)//2
    # print(start, end,mid)
    #  bfs
    if bfs(mid):
        res = mid
        start = mid+1
    else:
        end = mid-1


print(res)