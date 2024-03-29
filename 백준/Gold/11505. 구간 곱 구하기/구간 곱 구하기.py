import sys
input =sys.stdin.readline
sys.setrecursionlimit(10**8)
MOD = 1000000007
def init(start,end,node):
    if start==end:
        tree[node] = nums[start]
        return tree[node]
    mid = (start+end)//2
    tree[node] = (init(start,mid,node*2) * init(mid+1, end,node*2+1)) % MOD
    return tree[node]


def update(node,start,end,what,value):
    if what<start or what>end:
        return
    if start == end:
        tree[node] = value
        return

    mid = (start+end)//2
    update(node*2, start,mid, what,value)
    update(node*2+1,mid+1, end, what,value)
    tree[node] = (tree[node*2]*tree[node*2+1])%MOD

def find(node,start,end,left,right):
    if left>end or right<start:
        return 1

    if left<=start and right>=end:
        return tree[node]

    mid = (start+end)//2
    l = find(node*2,start,mid,left,right)
    r = find(node*2+1,mid+1,end,left,right)

    return (l*r)%MOD

n,m,k = map(int, input().split())
nums = [int(input()) for _ in range(n)]
tree = [0 for _ in range(4*n)]
init(0,n-1,1)

for _ in range(m+k):
    a,b,c = map(int, input().split())
    if a==1:
        update(1,0,n-1,b-1,c)
        nums[b-1]=c
    else:
        print(int(find(1,0,n-1,b-1,c-1)%MOD))