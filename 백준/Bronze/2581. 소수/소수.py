import math

m = int(input())
n = int(input())

arr = [True for i in range(n+1)]
arr[0] = False
arr[1] = False
for i in range(2, int(math.sqrt(n))+1):
    if arr[i] == True:
        j=2
        while i*j<=n:
            arr[i*j] = False
            j+=1

sum = 0
res = 0
for i in range(m, n+1):
    if arr[i]:
        if res == 0:
            res = i
        sum += i
        #print(i, end=" ")

if sum == 0:
    print(-1)
else:
    print(sum)
    print(res)