import sys
from collections import defaultdict

input = sys.stdin.readline

n = int(input())
dict = defaultdict(int)
for i in range(n):
    te, tx = map(int, input().split())
    dict[te] +=1
    dict[tx] -=1

sorted_keys = sorted(dict.keys())

res = 0
res_te,res_tx = 0,0
cnt = 0
flag = False
for k in sorted_keys:
    cnt += dict[k]
    if cnt>res: # 모기 많은 시간대 시작
        res = cnt
        res_te = k
        flag = True

    elif cnt<res and flag:
        res_tx = k
        flag = False

print(res)
print(res_te, res_tx)