import sys
input = sys.stdin.readline
N, K = map(int, input().split())

things = [list(map(int, input().split())) for _ in range(N)]
bags = [0] * (K + 1)

for i in range(N):
    w,v = things[i]
    for k in range(K, 0, -1):
        if k-w<0:
            break
        bags[k] = max(bags[k-w]+v, bags[k])
    # print(*bags)
print(bags[K])