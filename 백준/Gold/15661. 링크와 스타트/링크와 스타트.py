import sys
from itertools import combinations

def calc_score(S):
    global mat
    ret = 0
    for i, j in combinations(S, 2):
        ret += mat[i][j]+mat[j][i]
    return ret

ans = 1e5
N = int(input())
S = set(range(N))
mat = [list(map(int, input().split())) for _ in range(N)]
for cnt in range(1, N//2+1):
    for comb in combinations(list(range(N)), cnt):
        C = set(comb)
        a = calc_score(C)
        b = calc_score(S-C)
        ret = abs(a-b)
        if ans > ret:
            ans = ret
            if not ans: break

print(ans)