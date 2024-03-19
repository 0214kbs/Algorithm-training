import sys, heapq

input = sys.stdin.readline

v, e= map(int, input().split())
visit = [False]*(v+1)
trees = {}
for i in range(1,v+1):
    trees[i] = []
for _ in range(e):
    a,b,c = map(int, input().split())
    trees[a].append([c,b])
    trees[b].append([c,a])

cnt = 0
res = 0
q = []
heapq.heappush(q,[0,1])
while q:
    if cnt == v:
        break
    val, nxt = heapq.heappop(q)
    if not visit[nxt]:
        visit[nxt] = True
        cnt += 1
        res += val
        for i in trees[nxt]:
            heapq.heappush(q,i)

print(res)