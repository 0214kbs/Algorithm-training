import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**5)
INF = int(1e9)

def init(start,end, idx):
    if start == end:
        stree[idx] = nums[start]
        return stree[idx]

    mid = (start+end)//2
    stree[idx] = min(init(start,mid,idx*2), init(mid+1, end, idx*2+1))
    return stree[idx]

def find(start,end, idx, left, right):
    if left>end or right <start:
        return INF
    if left <= start and end<= right:
        return stree[idx]

    mid = (start+end)//2
    return min(find(start,mid,idx*2, left,right), find(mid+1, end, idx*2+1, left,right))


n,m = map(int, input().split())
nums = [0]+list(int(input()) for _ in range(n))
stree = [0 for _ in range(4*n)]
init(1,n,1)
for _ in range(m):
    a,b = map(int, input().split())
    print(find(1,n,1,a,b))