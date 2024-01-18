N,M = map(int, input().split())

res = [0]*M

def dfs(L,BW):
    if L == M:
        # print(res)
        for r in res:
            print(r, end=" ")
        print()
    else:
        for i in range(BW,N+1):
            if L>0 and i>=res[L-1]:
                res[L] = i
            if L == 0 :
                res[L] = i
            dfs(L + 1, i)


dfs(0,1)