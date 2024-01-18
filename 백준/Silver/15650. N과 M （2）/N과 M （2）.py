N,M = map(int, input().split())

res = [0]*M

def dfs(L,BW):
    if L == M:
        # print(res)
        for r in res:
            print(r, end=" ")
        print()
    else:
        for i in range(BW, N+1):
            res[L] = i
            dfs(L+1,i+1)

dfs(0,1)