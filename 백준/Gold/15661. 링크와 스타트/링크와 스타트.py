from itertools import combinations


def calc_score(S):
    global mat
    ret = 0
    for i, j in combinations(S, 2):
        ret += mat[i][j]+mat[j][i]
    return ret

def dfs(L, BW, current_set, remaining_set):
    global ans
    if L == r:
        a = calc_score(current_set)
        b = calc_score(remaining_set - current_set)
        ret = abs(a - b)
        if ans > ret:
            ans = ret
    else:
        for i in range(BW, len(n)):
            res[L] = n[i]
            dfs(L + 1, i + 1, current_set | {n[i]}, remaining_set)

ans = 1e9
N = int(input())
S = set(range(N))
mat = [list(map(int, input().split())) for _ in range(N)]

for cnt in range(1, N//2 + 1):
    n = list(range(N))
    r = cnt
    res = [0] * r
    dfs(0, 0, set(), S)

print(ans)