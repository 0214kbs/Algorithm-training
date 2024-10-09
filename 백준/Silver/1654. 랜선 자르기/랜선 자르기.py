import sys
input = sys.stdin.readline

def count_n(x):
    cnt = 0
    for l in lans:
        cnt += l//x
    return cnt

K, N = map(int, input().split())
lans = [int(input()) for _ in range(K)]

start = 1
end = max(lans)

while start<=end:
    mid = (start+end)//2
    cnt = count_n(mid)
    if cnt>=N:
        start = mid+1
    else:
        end = mid -1
print(end)