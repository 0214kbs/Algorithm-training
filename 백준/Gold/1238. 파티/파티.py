import sys, heapq
input = sys.stdin.readline

def func(s):
    D = [float(1e9)]*(N+1)
    D[s] = 0
    q = []
    heapq.heappush(q,(0,s))
    while q:
        dist,now = heapq.heappop(q)
        if D[now]>=dist:
            for v,val in cities[now]:
                if dist+val<D[v]:
                    D[v] = dist+val
                    heapq.heappush(q,(dist+val,v))
    return D

N,M,X = map(int,input().split())
cities = [[] for _ in range(N+1)]
for i in range(M):
    a,b,t= map(int,input().split())
    cities[a].append([b,t])
ans = func(X)
ans[0] = 0
for i in range(1,N+1):
    if i!=X:
        tmp = func(i)
        ans[i] += tmp[X]
# print(ans)
print(max(ans))