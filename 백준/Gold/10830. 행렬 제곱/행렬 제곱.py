import sys
input = sys.stdin.readline


def mul(U, V):
    n = len(U)
    Z = [[0] * n for _ in range(n)]

    for row in range(n):
        for col in range(n):
            e = 0
            for i in range(n):
                e += U[row][i] * V[i][col]
            Z[row][col] = e%1000
    return Z

def calc(A,B): # A 행렬 B 제곱
    if B == 1:
        for r in range(len(A)):
            for c in range(len(A)):
                A[r][c] %= 1000
        return A

    tmp = calc(A,B//2)
    if B%2:
        return mul(mul(tmp,tmp),A)
    else:
        return mul(tmp,tmp)

N, B = map(int, input().split())
A = [[0]*N for _ in range(N)]
for i in range(N):
    A[i] = list(map(int, input().split()))
res = calc(A,B)
for r in res:
    print(*r)