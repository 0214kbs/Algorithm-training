import sys
input = sys.stdin.readline
N, K = map(int, input().split())

things = [[0,0]]
for _ in range(N):
    W,V = map(int, input().split())
    things.append([W,V])

bags = [[0]*(K+1) for _ in range((N+1))]
for i in range(1,N+1):
    w,v = things[i]
    if w>K:
        for j in range(K+1):
            bags[i][j] = bags[i-1][j]
        continue
    for j in range(w):
        bags[i][j] = bags[i-1][j]
    for j in range(w,K+1):
        if j>w:
            bags[i][j] = max(v, bags[i-1][j],bags[i-1][j-w]+v)
        else:
            bags[i][j] = max(v, bags[i-1][j])
    # print(*bags)
print(max(bags[-1]))