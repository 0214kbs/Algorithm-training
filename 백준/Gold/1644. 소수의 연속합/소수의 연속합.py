def prime_numbers(n):
    arr = [i for i in range(n+1)]

    end = int(n**(1/2))
    for i in range(2, end+1):
        if arr[i] == 0:
            continue
        for j in range(i*i, n+1, i):
            arr[j] = 0
    return [i for i in arr[2:] if arr[i]]

n = int(input())
arr = prime_numbers(n)
# print(arr)

start, end = 0,0
sum_v = arr[0] if len(arr)>0 else 0
cnt = 0

while end<len(arr):
    # print(start,end,sum_v)
    if sum_v == n:
        cnt+=1
        end+=1
        if end<len(arr): sum_v += arr[end]
    elif sum_v<n:
        end+=1
        if end < len(arr): sum_v += arr[end]
    else:
        sum_v -= arr[start]
        start+=1

print(cnt)