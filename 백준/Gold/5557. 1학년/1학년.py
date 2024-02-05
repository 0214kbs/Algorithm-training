import sys
input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))

check = [[0]*21 for _ in range(N)]

check[0][arr[0]] = 1
for i in range(1,N-1):
    for j in range(21):
        if check[i-1][j] !=0:
            if j+arr[i] <= 20:
                check[i][j+arr[i]] += check[i-1][j]
            if j-arr[i] >=0 :
                check[i][j-arr[i]] += check[i-1][j]

print(check[N-2][arr[-1]])