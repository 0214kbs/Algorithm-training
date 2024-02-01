import sys
input = sys.stdin.readline
N = int(input())


def dfs(L):
    if L == len(slist):
        print("".join(res))
        return
    for c in visited:
        if visited[c]>0:
            visited[c] -=1
            res.append(c)
            dfs(L+1)
            visited[c] += 1
            res.pop()


for _ in range(N):
    slist = sorted(list(map(str, input().strip())))
    visited = {}
    for i in slist:
        if i in visited:
            visited[i] += 1
        else:
            visited[i] = 1
    res = []
    dfs(0)