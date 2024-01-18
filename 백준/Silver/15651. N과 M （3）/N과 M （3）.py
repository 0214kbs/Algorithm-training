N,M = map(int, input().split())

res = [0]*M

def dfs(L):
    if L == M:
        # print(res)
        for r in res:
            print(r, end=" ")
        print()
    else:
        for i in range(1,N+1):
            res[L] = i
            dfs(L+1)

dfs(0)