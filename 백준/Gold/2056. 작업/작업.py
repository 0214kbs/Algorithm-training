import sys
from collections import deque

input = sys.stdin.readline
N= int(input())

times = [0]*(N+1)
check = [0]*(N+1)
dp = [0]*(N+1)

graph = dict()
q = deque()

for i in range(1,N+1):
    graph[i] = []

for i in range(1,N+1):
    tmp = list(map(int, input().split()))
    times[i] = tmp[0]

    if tmp[1] == 0:
        q.append(i)
        dp[i] = tmp[0]
    else:
        for t in tmp[2:]:
            graph[t].append(i)
            check[i] += 1


while q:
    now = q.popleft()
    for t in graph[now]:
        check[t] -= 1
        dp[t] = max(dp[now]+times[t], dp[t])
        if check[t] == 0:
            q.append(t)

# print(dp)
print(max(dp))