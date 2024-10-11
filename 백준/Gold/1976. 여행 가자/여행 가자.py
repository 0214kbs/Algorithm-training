import sys
from collections import deque
input = sys.stdin.readline


N = int(input())
M = int(input())

sets = [0 for _ in range(N+1)]
graph = {i:[]for i in range(1,N+1)}
for i in range(1,N+1):
    tmp = list(map(int, input().split()))
    for j in range(1,N+1):
        if tmp[j-1] == 1:
            graph[i].append(j)
# print(graph)
cur_set = 1
for i in range(1,N+1):
    if sets[i] > 0:
        continue
    # sets 체크
    q = deque()
    q.append(i)
    sets[i] = cur_set
    while q:
        cur = q.popleft()
        for nxt in graph[cur]:
            if sets[nxt] == 0:
                q.append(nxt)
                sets[nxt] = cur_set
    cur_set += 1

# print(sets[1:])
travels = list(map(int, input().split()))
res = set()
for t in travels:
    res.add(sets[t])
if len(res) == 1:
    print("YES")
else:
    print("NO")