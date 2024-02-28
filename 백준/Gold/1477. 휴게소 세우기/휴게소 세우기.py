import sys
input = sys.stdin.readline

n, m, l = map(int, input().split())
pos = [0]+list(map(int, input().split()))+[l]
pos.sort()

res = 0
s,e = 1, l-1

while s<=e:
    cnt = 0
    mid = (s+e)//2

    for i in range(1, len(pos)):
        if pos[i]-pos[i-1] > mid:
            cnt += (pos[i]-pos[i-1]-1)//mid
    if cnt > m:
        s = mid+1
    else:
        e = mid -1
        res = mid
print(res)