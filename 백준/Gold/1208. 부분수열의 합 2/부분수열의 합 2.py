import sys

input = sys.stdin.readline

n, s = map(int, input().split())
nums = list(map(int, input().split()))

left_list = nums[:n // 2]
right_list = nums[n // 2:]

left_sum = {}
right_sum = {}


def bf(idx, now_sum, arr, sum_arr):
    if idx >= len(arr):
        if now_sum in sum_arr:
            sum_arr[now_sum] += 1
        else:
            sum_arr[now_sum] = 1
        return
    bf(idx + 1, now_sum, arr, sum_arr)
    bf(idx + 1, now_sum + arr[idx], arr, sum_arr)


bf(0, 0, left_list, left_sum)
bf(0, 0, right_list, right_sum)

res = 0
for left in left_sum:
    if s - left in right_sum:
        # print(left, s-left,left_sum[left],right_sum[s - left])
        res += left_sum[left] * right_sum[s - left]
if s == 0:
    res -=1

print(res)