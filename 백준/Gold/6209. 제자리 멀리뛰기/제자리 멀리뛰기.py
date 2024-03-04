import sys
input = sys.stdin.readline


d, n,m = map(int,input().split())
islands = sorted([int(input()) for _ in range(n)])+[d]

left = 0
right = d+1

while left<= right:
    mid = (left+right)//2
    cnt = 0
    now = 0

    for land in islands:
        if land-now < mid:
            cnt += 1
        else:
            now = land

    if cnt<=m:
        left = mid+1
    else:
        right = mid-1

print(right)