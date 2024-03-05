import sys
from collections import deque
input = sys.stdin.readline

n,m = map(int, input().split())
check = {}
for i in range(n+m):
    a,b = map(int, input().split())
    check[a] = b

q = deque()
q.append(1)
cnt_lst = [0 for _ in range(101)]
visited = [False for _ in range(101)]
visited[1] = True
while q:
    now = q.popleft()
    for i in range(1,7):
        next = now+i
        if next >100 or next<=0 or visited[next]:
            continue
        if next in check:
            next = check[next]

        if not visited[next]:
            q.append(next)
            cnt_lst[next] = cnt_lst[now]+1
            visited[next] = True
print(cnt_lst[100])