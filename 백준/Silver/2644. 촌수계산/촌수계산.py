import sys
input = sys.stdin.readline

def dfs(v):
    for i in board[v]:
        if visited[i] == 0:
            visited[i] = visited[v]+1
            dfs(i)

n = int(input())
board = [[] for _ in range(n+1)]
a,b = map(int, input().split())
m = int(input())
for i in range(m):
    x,y = map(int, input().split())
    board[x].append(y)
    board[y].append(x)

visited = [0] * (n+1)
dfs(a)
if(visited[b] >0):
    print(visited[b])
else:
    print(-1)