n,s = map(int,input().split())
nums = list(map(int, input().split()))
INF = int(1e9)
start, end = 0,0
res = INF
sum_v = nums[0]
if sum_v == s:
    res = 1
while start<=end<n:
    # print(start,end,':',sum_v)
    if sum_v<s:
        end+=1
        if end<n:
            sum_v+= nums[end]
    elif sum_v>=s:
        res = min(res,end-start+1)
        # print(res)
        sum_v-= nums[start]
        start+=1

if res == INF:
    print(0)
else:
    print(res)