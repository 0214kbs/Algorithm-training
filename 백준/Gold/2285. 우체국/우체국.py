import sys
input = sys.stdin.readline

n = int(input())
xalist = []

pos = 0
for i in range(n):
    x,a = map(int, input().split())
    xalist.append([x,a])
    pos += a

xalist.sort(key=lambda x: x[0])

cnt = 0
for i in range(n):
    cnt += xalist[i][1]
    if cnt>= pos/2:
        print(xalist[i][0])
        break