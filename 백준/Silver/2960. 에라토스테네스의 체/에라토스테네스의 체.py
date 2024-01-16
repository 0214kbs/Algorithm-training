N, K = map(int, input().split())
n_list = [False]*(N+1)
cnt = 0

for i in range(2,N+1):
    if not n_list[i]:
        for j in range(i,N+1,i):
            if not n_list[j]:
                n_list[j] = True
                cnt += 1
                if cnt == K:
                    print(j)