import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**5)
INF = int(1e9)

def init(start,end, idx):
    if start == end:
        stree[idx] = [nums[start],nums[start]]
        return stree[idx]

    mid = (start+end)//2
    left_v = init(start,mid,idx*2)
    right_v = init(mid+1, end, idx*2+1)

    stree[idx] = [min(left_v[0],right_v[0]),max(left_v[1],right_v[1])]
    return stree[idx]

def find(start,end, idx, left, right):
    if left>end or right <start:
        return [INF,0]
    if left <= start and end<= right:
        return stree[idx]

    mid = (start+end)//2
    left_v = find(start,mid,idx*2, left,right)
    right_v = find(mid+1, end, idx*2+1, left,right)
    return [min(left_v[0],right_v[0]),max(left_v[1],right_v[1])]

n,m = map(int, input().split())
nums = [0]+list(int(input()) for _ in range(n))
stree = [0 for _ in range(4*n)]
init(1,n,1)
for _ in range(m):
    a,b = map(int, input().split())
    res = find(1,n,1,a,b)
    print(*res)