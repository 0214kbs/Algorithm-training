import sys
from collections import deque
input = sys.stdin.readline

n,k = map(int,input().split())
lines = []
lines.append(list(map(int, input().rstrip())))
lines.append(list(map(int, input().rstrip())))

visited = [[False]*(n) for _ in range(2)]
res = False
visited[0][0] =True

q = deque()
q.append([0,0,0])

while q:
    line, idx, time = q.popleft()

    dx = [1,-1,k]

    for d in range(3):
        next = idx+dx[d]
        next_line = 1 if line==0 else 0

        if next >= n:
            res = True
            break
        if time<next and lines[line][next] == 1 and d !=2:
            if not visited[line][next]:
                visited[line][next]= True
                q.append([line,next,time+1])

        elif time<next and lines[next_line][next] == 1 and d == 2:
            if not visited[next_line][next]:
                visited[next_line][next] = True
                q.append([next_line,next,time+1])

print(1 if res else 0)