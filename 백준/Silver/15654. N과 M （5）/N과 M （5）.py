N,M = map(int, input().split())
lst = list(map(int, input().split()))
lst.sort()

res = [0]*M
check = [False]*N

def dfs(L):
    if L == M:
        # print(res)
        for r in res:
            print(r, end=" ")
        print()
    else:
        for i in range(N):
            if not check[i]:
                check[i] = True
                res[L] = lst[i]
                dfs(L+1)
                check[i] = False

dfs(0)