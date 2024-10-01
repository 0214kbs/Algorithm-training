import sys
input = sys.stdin.readline

brackets = list(input().rstrip())

res = 0
stick = 0
for i in range(len(brackets)):
    if brackets[i] == '(':
        if brackets[i+1] == ')': #레이저
            res += stick
        else:
            stick += 1
            res += 1
    else: #')'
        if brackets[i-1] != '(':
            stick -=1


print(res)