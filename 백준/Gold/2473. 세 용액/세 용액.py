import sys
input = sys.stdin.readline
n= int(input())
nums = list(map(int,input().split()))

nums.sort()
# print(nums)
res = nums[:3]
min_v = sys.maxsize

for k in range(n-2):
    start = nums[k]
    mid,end = k+1,n-1

    while mid<end:
        sum_v = start+nums[mid]+nums[end]
        if abs(sum_v)<min_v:
            min_v = abs(sum_v)
            res = [start,nums[mid],nums[end]]

        if sum_v<0:
            mid+=1
        elif sum_v>0:
            end-=1
        else:
            break

# res.sort()
print(*res)