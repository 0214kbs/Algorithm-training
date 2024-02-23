import sys
input = sys.stdin.readline

n = int(input())
roads = list(map(int, input().split()))
prices = list(map(int, input().split()))

i = 0
price = 0

while True:
    # print(i, price)
    if i == n:
        break
    tmp = i
    for j in range(i,n-1):
        if prices[j]<prices[i]:
            tmp = j
            break
    dist = 0
    if tmp == i: # i의 price가 제일 작음
        for j in range(i,len(roads)):
            dist += roads[j]
        price += dist*prices[i]
        i=n
    else:
        for j in range(i, tmp):
            dist += roads[j]
        price += dist*prices[i]
        i = tmp

print(price)