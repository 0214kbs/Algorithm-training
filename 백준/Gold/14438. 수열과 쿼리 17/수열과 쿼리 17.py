import sys
sys.setrecursionlimit(10**5)
input =sys.stdin.readline
INF = int(2e9)
n = int(input())
a = [0]+list(map(int, input().split()))
m = int(input())
stree = [0 for _ in range(4*n)]

def init(start,end, idx):
    if start == end:
        stree[idx] = a[start]
        return
    mid = (start+end)//2
    init(start, mid, idx * 2)
    init(mid + 1, end, idx * 2 + 1)
    stree[idx] = min(stree[idx*2],stree[idx*2+1])


def find(start,end, idx, left, right):
    if left > end or right < start:
        return INF
    if left <= start and end<= right:
        return stree[idx]
    mid = (start + end) // 2
    return min(find(start, mid, idx * 2,left,right), find(mid + 1, end, idx * 2 + 1,left,right))


def update(start,end,idx,ch_idx, value):
    if ch_idx<start or ch_idx>end:
        return
    if start == end:
        stree[idx] = value
        return

    mid = (start + end) // 2
    update(start, mid, idx * 2, ch_idx, value)
    update(mid + 1, end, idx * 2 + 1, ch_idx, value)
    stree[idx] = min(stree[idx*2], stree[idx*2+1])


init(1,n,1)
for _ in range(m):
    o, i,j = map(int, input().split())
    if o == 1:
        update(1,n,1,i,j)
    else:
        print(find(1,n,1,i,j))