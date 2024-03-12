n = int(input())
nums = list(map(int,input().split()))

nums.sort()
# print(nums)
start = 0
end = n-1

check = int(1e9)*2
res = [0,n-1]
while start<end:
    tmp = nums[start]+nums[end]
    # print(start,end, ':', check, abs(tmp))
    if abs(tmp)<check:
        check = abs(tmp)
        res = [start,end]
    if tmp>0:
        end -=1
    else:
        start+=1
print(nums[res[0]], nums[res[1]])