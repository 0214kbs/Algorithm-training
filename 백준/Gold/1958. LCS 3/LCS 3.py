import sys
input = sys.stdin.readline
A = input().rstrip()
B = input().rstrip()
C = input().rstrip()

res = 0
LCS = [[[0] * (len(C)+1) for _ in range(len(B)+1)] for _ in range(len(A)+1) ]
for i in range(1, len(A)+1):
    for j in range(1, len(B)+1):
        for k in range(1,len(C)+1):
            if A[i-1] == B[j-1] == C[k-1]:
                LCS[i][j][k] = LCS[i-1][j-1][k-1]+1
            else:
                LCS[i][j][k] = max(LCS[i-1][j][k], LCS[i][j-1][k], LCS[i][j][k-1])
            res = max(LCS[i][j][k],res)

print(res)