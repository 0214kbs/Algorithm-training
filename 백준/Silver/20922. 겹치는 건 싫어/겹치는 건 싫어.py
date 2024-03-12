n,k = map(int, input().split())
nums = list(map(int, input().split()))

start = 0
end = 0
check = [0]*(max(nums)+1)

res = 0
while end<n:
    if check[nums[end]]<k:
        check[nums[end]] +=1
        end +=1
    else:
        check[nums[start]] -=1
        start +=1
    res = max(res, end-start)
print(res)