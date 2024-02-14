import sys
input = sys.stdin.readline

n,m,k = map(int, input().split())
board= []
for _ in range(n):
    board.append(list(input().strip()))

B_prefix = [[0]*(m+1) for _ in range(n+1)]
W_prefix = [[0]*(m+1) for _ in range(n+1)]

for i in range(n):
    for j in range(m):
        if (i+j) %2 == 0:
            if board[i][j] == 'B':
                B_prefix[i][j] = B_prefix[i-1][j]+B_prefix[i][j-1]-B_prefix[i-1][j-1] +1
                W_prefix[i][j] = W_prefix[i-1][j]+W_prefix[i][j-1]-W_prefix[i-1][j-1]
            else:
                B_prefix[i][j] = B_prefix[i-1][j]+B_prefix[i][j-1]-B_prefix[i-1][j-1]
                W_prefix[i][j] = W_prefix[i-1][j]+W_prefix[i][j-1]-W_prefix[i-1][j-1]+1
        else:
            if board[i][j] == 'B':
                B_prefix[i][j] = B_prefix[i-1][j]+B_prefix[i][j-1]-B_prefix[i-1][j-1]
                W_prefix[i][j] = W_prefix[i-1][j]+W_prefix[i][j-1]-W_prefix[i-1][j-1] +1
            else:
                B_prefix[i][j] = B_prefix[i-1][j]+B_prefix[i][j-1]-B_prefix[i-1][j-1] +1
                W_prefix[i][j] = W_prefix[i-1][j]+W_prefix[i][j-1]-W_prefix[i-1][j-1]

res = 1e9
for i in range(n-k+1):
    for j in range(m-k+1):
        B_tmp = B_prefix[i+k-1][j+k-1]-B_prefix[i-1][j+k-1]-B_prefix[i+k-1][j-1]+B_prefix[i-1][j-1]
        W_tmp = W_prefix[i+k-1][j+k-1]-W_prefix[i-1][j+k-1]-W_prefix[i+k-1][j-1]+W_prefix[i-1][j-1]
        # print(i,j,B_tmp, W_tmp)
        res = min(res,B_tmp,W_tmp)
# print(B_prefix)
# print(W_prefix)
print(res)