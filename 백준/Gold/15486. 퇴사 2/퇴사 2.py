import sys
input = sys.stdin.readline

N = int(input())
check = [0 for _ in range(N+1)]
for i in range(1, N+1):
    ti, pi = map(int, input().split())
    check[i] = max(check[i], check[i-1])
    if i+ti-1 >N:
        continue
    check[i+ti-1] = max(check[i+ti-1], check[i-1]+pi)
print(max(check))
