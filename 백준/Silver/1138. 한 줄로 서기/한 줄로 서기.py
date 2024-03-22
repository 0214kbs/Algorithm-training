import sys
input = sys.stdin.readline

n = int(input())
fronts = list(map(int,input().split()))

res = [0]*n

for i in range(n):
    cnt = 0
    for j in range(n):
        if res[j] == 0:
            cnt+=1
        if cnt>fronts[i] and res[j] == 0:
            res[j] = i+1
            break
print(*res)