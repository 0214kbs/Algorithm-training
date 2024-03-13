import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**9)
def find(i):
    count[i] = 1
    for g in graph[i]:
        if count[g] == 0:
            find(g)
            count[i] += count[g]

n,r,Q = map(int, input().split())
graph = dict()
for i in range(1,n+1):
    graph[i] = []
for _ in range(n-1):
    a,b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

count = [0]*(n+1)
find(r)

for _ in range(Q):
    q = int(input())
    print(count[q])