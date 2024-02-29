import sys
input = sys.stdin.readline

n,m,l = map(int, input().split())
sizes = [int(input()) for _ in range(m)]+[l]

def calc(mid):
    cnt, tmp = 0,0
    for s in sizes:
        if s - tmp >= mid:
            cnt +=1
            tmp = s
    return cnt


for i in range(n):
    q = int(input())

    left = 0
    right = l
    res = 0
    while left <= right:
        mid = (left+right)//2

        cnt = calc(mid)

        if cnt > q:
            left = mid+1
            res = max(res, mid)
        else:
            right = mid -1
    print(res)