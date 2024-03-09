from collections import deque
n, k = map(int, input().split())
MAX_SIZE = 100001

q = deque()
q.append(n)
visited = [-1]*MAX_SIZE
visited[n] = 0
cnt = 0
while q:
    cur = q.popleft()
    if cur == k:
        cnt +=1
    for i in [cur+1,cur-1,cur*2]:
        if 0<=i<100001:
            if visited[i] == -1 or visited[i] >= visited[cur]+1:
                visited[i] = visited[cur]+1
                q.append(i)
print(visited[k])
print(cnt)
