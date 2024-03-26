import sys,heapq
input = sys.stdin.readline

n,m = map(int, input().split())
graph = [[] for _ in range(n+1)]
check = [0 for _ in range(n+1)]

for _ in range(m):
    a,b = map(int, input().split())
    graph[a].append(b)
    check[b]+=1

q = []
res = []
for i in range(1,n+1):
    if check[i] == 0:
        heapq.heappush(q,i)

while q:
    cur = heapq.heappop(q)
    res.append(cur)
    for g in graph[cur]:
        check[g] -=1
        if check[g] == 0:
            heapq.heappush(q,g)
print(*res)