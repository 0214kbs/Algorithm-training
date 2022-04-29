import sys
input = sys.stdin.readline

n = int(input())
a = list(map(int,input().split()))
b, c = map(int,input().split())

cnt =0
for i in range(n):
    a[i] -= b
    cnt += 1
    t = int(a[i] / c)
    if a[i] > 0 and a[i]%c == 0:
        cnt = cnt + t
    elif a[i]>0 and a[i]%c != 0:
        cnt = cnt + t+1
    else:
        pass

print(cnt)