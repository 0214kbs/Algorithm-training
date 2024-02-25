import sys, heapq
input = sys.stdin.readline

n = int(input())
dasom = int(input())

others = []

for _ in range(n-1):
    num = int(input())
    heapq.heappush(others,(-num,num))

cnt = 0
while len(others)>0:
    num = heapq.heappop(others)[1]
    if num >= dasom:
        num -=1
        dasom +=1
        cnt += 1
        heapq.heappush(others,(-num,num))

print(cnt)