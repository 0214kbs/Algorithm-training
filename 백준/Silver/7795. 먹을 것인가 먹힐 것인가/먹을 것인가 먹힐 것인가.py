import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    N, M = map(int, input().split())
    alist = list(map(int, input().split()))
    blist = list(map(int, input().split()))
    res = 0
    blist.sort()
    for a in alist:
        s, e = 0, len(blist)-1
        while s<=e:
            m = (s+e)//2
            if blist[m] < a:
                s = m+1
            else:
                e = m-1
        res += s
    print(res)

