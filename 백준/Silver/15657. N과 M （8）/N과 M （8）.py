N,M = map(int, input().split())
lst = list(map(int, input().split()))
lst.sort()

res = []

def dfs(L,BW):
    if L == M:
        # print(res)
        for r in res:
            print(r, end=" ")
        print()
    else:
        for i in range(BW,len(lst)):
            res.append(lst[i])
            dfs(L+1,i)
            res.pop()

dfs(0,0)