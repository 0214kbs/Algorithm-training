import sys
from math import *
input = sys.stdin.readline
INF = sys.maxsize

def min(a:list, b:list) -> list:
    if a[0] > b[0]:
        return b
    else:
        return a

def init(start,end, idx):
    if start == end:
        stree[idx] = nums[start]
        return stree[idx]

    mid = (start+end)//2
    stree[idx] = min(init(start,mid,idx*2), init(mid+1, end, idx*2+1))
    return stree[idx]

def find(start,end, idx, left, right):
    if left>end or right <start:
        return [INF,INF]
    if left <= start and end<= right:
        return stree[idx]

    mid = (start+end)//2
    return min(find(start,mid,idx*2, left,right), find(mid+1, end, idx*2+1, left,right))

def update(node,start,end,what,value):
    if what<start or what>end:
        return [INF,INF]
    if start == end:
        stree[node] = value
        return

    mid = (start+end)//2
    update(node*2,start,mid,what,value)
    update(node*2+1,mid+1,end,what,value)

    stree[node] = min(stree[node*2],stree[node*2+1])

n = int(input())
tmp = list(map(int, input().split()))
nums = [[0, 0] for _ in range(n)]
for i in range(n):
    nums[i] = [tmp[i],i+1]
stree = [0 for _ in range(4*n)]
init(0,n-1,1)
m = int(input())
for _ in range(m):
    a,b,c = map(int, input().split())
    if a==1:
        nums[b-1][0] = c
        update(1,0,n-1,b-1,nums[b-1])
    else:
        print(find(0,n-1,1,b-1,c-1)[1])