import sys
input = sys.stdin.readline

n = int(input())
nums = list(map(int, input().split()))
F = [0]*(max(nums)+1)
for i in range(n):
    F[nums[i]]+=1

NGF= [-1]*n
stack = [0]
for i in range(1,n):
    while stack and F[nums[stack[-1]]] < F[nums[i]]:
        NGF[stack.pop()] = nums[i]
    stack.append(i)
print(*NGF)
