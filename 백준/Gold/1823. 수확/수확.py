import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**5)

N = int(input())
rice_list = [int(input()) for i in range(N)]

dp = [[0]*N for _ in range(N)]

def check(left, right, cnt):
    # print(left, right, 'count', cnt)
    if left==right:
        return cnt*rice_list[left]

    if dp[left][right]:
        return dp[left][right]

    dp[left][right] = max(check(left+1, right, cnt+1) + rice_list[left] * cnt, check(left, right-1, cnt+1) + rice_list[right] * cnt)
    return dp[left][right]

print(check(0,N-1,1))