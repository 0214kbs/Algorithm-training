import sys
from collections import deque
input = sys.stdin.readline

def istree(i):
    flag = True
    q = deque()
    q.append(i)
    while q:
        cur = q.popleft()
        if visited[cur]: # cycle
            flag = False
        visited[cur] = True
        for g in graph[cur]:
            if g==cur:
                flag = False
            if not visited[g]:
                q.append(g)
    return flag

turn =1
while True:
    n,m = map(int, input().split())
    if (n,m) == (0,0):
        break

    graph = {}
    for i in range(1,n+1):
        graph[i] = []
    for _ in range(m):
        a,b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    tree = 0
    visited = [False]*(n+1)
    for i in range(1,n+1):
        if not visited[i]:
            if istree(i):
                tree += 1
    if tree == 0:
        print(f'Case {turn}: No trees.')
    elif tree == 1:
        print(f'Case {turn}: There is one tree.')
    else:
        print(f'Case {turn}: A forest of {tree} trees.')
    turn +=1