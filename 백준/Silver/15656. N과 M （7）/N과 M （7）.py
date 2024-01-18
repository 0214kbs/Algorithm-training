N,M = map(int, input().split())
lst = list(map(int, input().split()))
lst.sort()

res = [0]*M

def dfs(L):
    if L == M:
        # print(res)
        for r in res:
            print(r, end=" ")
        print()
    else:
        for i in range(len(lst)):
            res[L] = lst[i]
            dfs(L+1)
dfs(0)