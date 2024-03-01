import sys
input = sys.stdin.readline

n, k = map(int, input().split())
nums = list(map(int, input().split()))

left, right = 0, 100000*20+1
res = 0

while left<=right:
    mid = (left+right)//2
    group = 0
    score = 0
    for num in nums:
        score += num
        if score >= mid:
            group +=1
            score = 0
    if group >= k:
        res = mid
        left = mid+1
    else:
        right = mid -1
print(res)