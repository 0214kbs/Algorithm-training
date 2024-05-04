import sys
input = sys.stdin.readline

N = int(input())
arr = []
for i in range(N):
    arr.append((int(input()), i))
arr.sort()

res = 0
for i in range(N):
    res = max(res,arr[i][1] - i)
print(res+1)