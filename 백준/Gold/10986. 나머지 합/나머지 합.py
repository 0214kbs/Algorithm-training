import sys
input = sys.stdin.readline

n,m = map(int, input().split())
alist = list(map(int, input().split()))

r_list = [0]*m
prefix_sum = 0
for a in alist:
    prefix_sum += a
    r_list[prefix_sum%m]+=1

res = r_list[0]
for i in range(m):
    res+= r_list[i]*(r_list[i]-1) // 2
print(res)