import sys
sys.setrecursionlimit(10**5)
input = sys.stdin.readline

def dfs(x):
    global res
    visited[x] = True
    cycle.append(x)
    w = nums[x]
    if visited[w]:
        if w in cycle:
            res += cycle[cycle.index(w):]
        return
    else:
        dfs(w)

t = int(input())
for _ in range(t):
    n = int(input())
    nums= [0]+list(map(int, input().split()))
    visited = [True]+[False]*n
    res = []

    for i in range(1,n+1):
        if not visited[i]:
            cycle= []
            dfs(i)
    print(n-len(res))