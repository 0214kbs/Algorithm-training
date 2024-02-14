import sys
input = sys.stdin.readline
S = input().strip()
q = int(input())
alpha = 'abcdefghijklmnopqrstuvwxyz'

dict = {}
for a in alpha:
    cnt = 0
    tmp = [0]*len(S)
    for i in range(len(S)):
        if a == S[i]:
            cnt += 1
        tmp[i] = cnt
    dict[a] = tmp

for _ in range(q):
    a, l, r = input().split()
    l, r = int(l), int(r)
    acc_sum = dict[a]
    if l == 0:
        print(acc_sum[r])
    else:
        print(acc_sum[r] - acc_sum[l-1])