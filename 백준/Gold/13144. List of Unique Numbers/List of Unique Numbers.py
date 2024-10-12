import sys
input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))
s, e = 0,0
res = 0
visited = [False] * 100001

while True:
    if s == N or e == N:
        break
    if visited[nums[e]]: # 중복되는 경우
        while visited[nums[e]]:
            visited[nums[s]] = False
            s+=1
    else:
        visited[nums[e]] = True
        e+=1
        res += e-s
print(res)