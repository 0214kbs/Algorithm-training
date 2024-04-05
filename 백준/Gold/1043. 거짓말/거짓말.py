import sys
input = sys.stdin.readline

def find(idx):
    if parent[idx] != idx:
        parent[idx] = find(parent[idx])
    return parent[idx]

def union(i,j):
    a = find(i)
    b = find(j)
    parent[max(a,b)] = min(a,b)

def check(i,j):
    return find(i) == find(j)


n,m = map(int, input().split())
knows = [False]*(n+1)
parent = [i for i in range(n+1)]
t, *tp = map(int, input().split())
for i in range(t):
    knows[tp[i]] = True

parties = []
for _ in range(m):
    p,*pp = map(int, input().split())
    parties.append(pp)

    if p>1:
        for i in range(p-1):
            union(pp[i],pp[i+1])

for i in range(1,n+1):
    if knows[i]:
        knows[find(i)] = True

if t == 0:
    print(m)
else:
    res = 0
    for party in parties:
        flag = True
        for p in party:
            if knows[find(p)]:
                flag = False
        if flag:
            res +=1
    print(res)