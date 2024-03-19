import sys,heapq
input = sys.stdin.readline

n = int(input())
m = int(input())

edges = [[] for _ in range(n+1)]
for _ in range(m):
    a,b,c = map(int, input().split())
    if a==b:
        continue
    edges[a].append([c,b])
    edges[b].append([c,a])

visit = [False]*(n+1)
cnt = 0
res = 0
q = []
heapq.heappush(q,[0,1])
while q:
    if cnt == n:
        break
    val, cur = heapq.heappop(q)
    if not visit[cur]:
        cnt +=1
        visit[cur] = True
        res+=val
        for e in edges[cur]:
            heapq.heappush(q,e)
print(res)