import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
nums =list(map(int, input().split()))
a = [i for i in range(1, N+1)]
q = deque(a)

res = 0
for num in nums:
    while True:
        if num == q[0]:
            q.popleft()
            break
        else:
            if q.index(num) > len(q)//2:
                q.rotate()
                res +=1
            else:
                q.rotate(-1)
                res +=1
print(res)