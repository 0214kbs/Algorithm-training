import sys
input = sys.stdin.readline

N = int(input())
tops = list(map(int, input().split()))
res = [0 for _ in range(N)]

stack = [(0,tops[0])]
for i in range(1, N):
    top = tops[i]
    while stack:
        if stack[-1][-1] >= top:
            res[i] = stack[-1][0]+1
            break
        stack.pop()
    stack.append((i, top))
print(*res)
