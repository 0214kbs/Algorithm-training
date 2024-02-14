n,k = map(int, input().split())
days = list(map(int, input().split()))

prefix_sum = [0]*n

prefix_sum[0] = days[0]
for i in range(1,n):
    prefix_sum[i] = prefix_sum[i-1]+days[i]

res = prefix_sum[k-1]
for i in range(k, n):
    tmp = prefix_sum[i] - prefix_sum[i-k]
    res = max(res, tmp)

print(res)