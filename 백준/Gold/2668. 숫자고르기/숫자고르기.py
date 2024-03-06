import sys
input = sys.stdin.readline

n = int(input())
nums = [0]+[int(input()) for _ in range(n)]
res = []

def dfs(curi,starti):
    visited[curi] = True
    w = nums[curi]
    if not visited[w]:
        dfs(w,starti)
    elif visited[w] and w == starti:
        res.append(w)

for i in range(1,n+1):
    visited = [False]*(n+1)
    dfs(i,i)
print(len(res))
res.sort()
for r in res:
    print(r)