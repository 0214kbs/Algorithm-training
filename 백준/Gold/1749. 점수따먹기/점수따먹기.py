import sys
input = sys.stdin.readline

n,m = map(int, input().split())
board = []
for i in range(n):
    board.append(list(map(int, input().split())))

sum_board = [[0]*(m+1) for _ in range(n+1)]

for cr in range(1,n+1):
    for cc in range(1,m+1):
        sum_board[cr][cc] = sum_board[cr-1][cc] + sum_board[cr][cc-1] + board[cr-1][cc-1] - sum_board[cr-1][cc-1]

# print(sum_board)
res = -1e9
for sr in range(1,n+1):
    for sc in range(1,m+1):
        for er in range(sr, n+1):
            for ec in range(sc, m+1):
                res = max(res, sum_board[er][ec] - sum_board[sr-1][ec] - sum_board[er][sc-1] + sum_board[sr-1][sc-1])

print(res)