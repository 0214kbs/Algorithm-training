import sys
input = sys.stdin.readline

n = int(input())
nums = list(map(int, input().split()))

NGE= [-1]*n
stack = [0]

for i in range(1, n):
    while stack and nums[i]>nums[stack[-1]]:
        NGE[stack[-1]] = nums[i]
        stack.pop()
    stack.append(i)

print(*NGE)