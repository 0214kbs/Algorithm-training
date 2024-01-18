N, M = map(int, input().split())

res = [0]*M
checklist = [False]*(N+1)

def dfs(L):
    if L == M:
        # print(res)
        for r in res:
            print(r,end=" ")
        print()
    else:
        for i in range(1,N+1):
            if not checklist[i]:
                res[L] = i
                checklist[i] = True

                dfs(L+1)

                checklist[i] = False


dfs(0)