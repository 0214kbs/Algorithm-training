import sys
sys.setrecursionlimit(10**6)
dr = [1,0,0,-1]
dc = [0,-1,1,0]
dv = ['d','l','r','u']
def calc(cr,cc, path, cnt,n, m, r, c, k):
    if cnt ==k:
        if cr == r and cc == c:
            return path
    else:
        for d in range(4):
            nr = cr+dr[d]
            nc = cc+dc[d]
            if nr<0 or nc<0 or nr>=n or nc>=m:
                continue
            dist = abs(nr-r) + abs(nc-c)
            if dist>k-(cnt+1):
                continue
            res = calc(nr,nc, path+dv[d], cnt+1 ,n, m,r, c, k)
            if res:
                return res
def solution(n, m, x, y, r, c, k):
    dist = abs(x - r) + abs(y - c)
    if dist > k or (k - dist) % 2 == 1:
        return "impossible"
    
    res = calc(x-1,y-1, "", 0 ,n, m, r-1, c-1, k)
    if res:
        return res
    return "impossible"
