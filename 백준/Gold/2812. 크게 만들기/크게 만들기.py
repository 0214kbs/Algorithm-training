import sys
input = sys.stdin.readline

n , k = map(int, input().split())
str_num = input().rstrip()

stack = []
for num in str_num:
    while stack and stack[-1] < num and k>0:
        stack.pop()
        k -=1
    stack.append(num)

if k>0:
    print(''.join(stack[:-k]))
else:
    print(''.join(stack))