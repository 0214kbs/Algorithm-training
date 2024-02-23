import sys,heapq
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    k = int(input())
    files = list(map(int, input().split()))
    heapq.heapify(files)
    res = 0

    #print(files)
    while len(files) >1:
        tmp = 0
        a = heapq.heappop(files)
        b = heapq.heappop(files)
        tmp += a+b
        res += tmp
        heapq.heappush(files,tmp)
        #print(files, res)
    print(res)