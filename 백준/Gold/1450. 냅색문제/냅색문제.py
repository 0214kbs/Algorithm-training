import sys
input = sys.stdin.readline

n, c =  map(int, input().split())
grams = list(map(int, input().split()))

left_list = grams[:n//2]
right_list = grams[n//2:]

left_sum = []
right_sum = []

def bruteforce(idx,sum_now,arr, sumarr):
    if idx>=len(arr):
        sumarr.append(sum_now)
        return
    bruteforce(idx+1,sum_now,arr,sumarr)
    bruteforce(idx+1,sum_now+arr[idx],arr,sumarr)

def bs(start,end,arr,target):
    while start<end:
        mid = (start+end) // 2
        if arr[mid] <= target:
            start = mid+1
        else:
            end = mid
    return end

bruteforce(0,0,left_list,left_sum)
bruteforce(0,0,right_list,right_sum)
right_sum.sort()

res = 0
for left in left_sum:
    if c-left >=0:
        res+= bs(0,len(right_sum),right_sum,c-left)

print(res)