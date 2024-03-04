import sys
input = sys.stdin.readline

n, m = map(int, input().split())
times = list(map(int, input().split()))


if n<m:
    print(n)
    exit()

left, right = 0, 60000000000
time = 0
while left<=right:
    mid = (left+right)//2

    tmp = m
    for i in range(m):
        tmp += mid//times[i]

    if tmp>=n:
        time = mid
        right = mid-1
    else:
        left = mid+1

tmp = m
for i in range(m):
    tmp += (time-1)//times[i]

for i in range(m):
    if time%times[i] == 0:
        tmp +=1
    if tmp == n:
        print(i+1)
        break