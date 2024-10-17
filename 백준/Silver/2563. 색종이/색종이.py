import sys
from collections import deque
input = sys.stdin.readline

n = int(input())

board = [[0]*100 for _ in range(100)]
for _ in range(n):
    a,b = map(int, input().split())
    for i in range(a,a+10):
        for j in range(b, b+10):
            board[i][j] = 1

res = 0
for i in range(100):
    res += sum(board[i])
print(res)

