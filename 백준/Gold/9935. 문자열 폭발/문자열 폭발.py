import sys
input = sys.stdin.readline

str1 = input().rstrip()
str2 = input().rstrip()

stack = []
for s in str1:
    if len(stack) < len(str2)-1:
        stack.append(s)
        continue
    if s == str2[-1]:
        flag = True
        for i in range(len(str2)-1):
            if str2[i] != stack[len(stack)-len(str2)+1+i]:
                flag = False
        if flag:
            for i in range(len(str2)-1):
                stack.pop()
        else:
            stack.append(s)
    else:
        stack.append(s)
if len(stack) == 0:
    print('FRULA')
else:
    for s in stack:
        print(s, end="")