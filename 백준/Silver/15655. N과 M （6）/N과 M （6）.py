N,M = map(int, input().split())
lst = list(map(int, input().split()))
lst.sort()
res = [0]*M

def dfs(L, BW):
    if L == M:
        # print(res)
        for r in res:
            print(r, end=" ")
        print()
    else:
        for i in range(BW, len(lst)):
            res[L] = lst[i]
            dfs(L+1,i+1)
dfs(0,0)