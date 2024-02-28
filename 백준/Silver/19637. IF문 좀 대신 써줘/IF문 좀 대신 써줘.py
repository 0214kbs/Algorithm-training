import sys
input = sys.stdin.readline

n, m = map(int, input().split())
name = []
value = []
for i in range(n):
    a,b = input().split()
    b = int(b)
    if value and value[-1] == b:
        continue
    value.append(b)
    name.append(a)

def bs(num):
    left = 0
    right = len(value)-1
    while left<=right:
        mid = (left+right)//2
        if num>value[mid]:
            left = mid + 1
        else:
            right = mid -1
    print(name[right+1])

for i in range(m):
    num = int(input())
    bs(num)