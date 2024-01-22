import sys
input = sys.stdin.readline
N,M,L,K = map(int, input().split())

xylist = []

for _ in range(K):
    x,y = map(int, input().split())
    xylist.append((x,y))

max_v = 0

for i in range(K):
    for j in range(K):
        tmp = 0
        for k in range(K):
            if (xylist[i][0] <= xylist[k][0] <= xylist[i][0] + L
                    and xylist[j][1] <= xylist[k][1] <= xylist[j][1] + L):
                tmp += 1
        max_v = max(tmp, max_v)
print(K-max_v)