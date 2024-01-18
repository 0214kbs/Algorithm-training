N,M = map(int, input().split())

res = []

def dfs(L,BW):
    if L == M:
        # print(res)
        for r in res:
            print(r, end=" ")
        print()
    else:
        for i in range(BW,N+1):
            res.append(i)
            dfs(L+1,i)
            res.pop()


dfs(0,1)