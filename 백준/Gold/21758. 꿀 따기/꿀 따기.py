n = int(input())
honey = list(map(int, input().split()))
h_sum = [honey[0]] + [0] * (n - 1)
res = 0

for i in range(1, n):
    h_sum[i] = h_sum[i - 1] + honey[i]

for i in range(1,n-1):
    # 벌~벌~통
    right = (h_sum[-1]-honey[0]-honey[i])+(h_sum[-1]-h_sum[i])

    # 통~벌~벌
    left = (h_sum[-1]-honey[-1]-honey[i])+(h_sum[i-1])

    # 벌~통~벌
    mid = (h_sum[i]-honey[0])+(h_sum[-1]-h_sum[i-1]-honey[-1])

    res = max(right, left, mid, res)
print(res)