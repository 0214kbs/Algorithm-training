import sys
input = sys.stdin.readline

m = int(input())
f = [0]+list(map(int, input().split()))
st = [[f[i]] for i in range(m+1)] #sparse table

for i in range(1,19):
    for j in range(1,m+1):
        st[j].append(st[st[j][i-1]][i-1])
q = int(input())
for _ in range(q):
    n,x  = map(int, input().split())
    for i in range(18,-1,-1):
        if n>= 2**i:
            n-=2**i
            x = st[x][i]

    print(x)