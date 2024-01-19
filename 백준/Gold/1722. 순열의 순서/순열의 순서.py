import sys
N = int(input())

tmp = list(map(int, input().split()))

fact = [0]*21
fact[0] = 1
for i in range(1,21):
    fact[i] = fact[i-1]*i

if tmp[0] == 1:
    k = tmp[1]
    res = []
    check = [False] * (N + 1)

    for i in range(N):
        for j in range(1, N+1):
            if check[j]:
                continue
            if fact[N-i-1] < k:
                k -= fact[N-i-1]
            else:
                check[j] = True
                res.append(j)
                break
    print(*res)

else:
    lst = tmp[1:]
    res = 1
    check = [0]*(N+1)
    for i in range(N):
        for j in range(1, lst[i]):
            if not check[j]:
                res += fact[N-1-i]
        check[lst[i]] = 1
    print(res)