import sys
input = sys.stdin.readline

n = int(input())
alist =list(map(int, input().split()))
x = int(input())

alist.sort()
s, e = 0,n-1
cnt = 0
while s<e:
    sumv = alist[s]+alist[e]
    if sumv == x:
        s+=1
        e-=1
        cnt += 1
    elif sumv <x:
        s += 1
    else:
        e -= 1
print(cnt)