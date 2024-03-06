import sys
input = sys.stdin.readline

def dfs(x):
    visited[x]= True
    next = nums[x]
    if not visited[next]:
        dfs(next)

t = int(input())
for _ in range(t):
    n = int(input())
    nums= [0]+list(map(int, input().split()))
    visited = [True]+[False]*n

    res = 0
    for i in range(1,n+1):
        if not visited[i]:
            dfs(i)
            res += 1
    print(res)