import sys
input = sys.stdin.readline

strng = input().rstrip()
res = 0
dict = {
    ')':['(','2'],
    ']':['[','3']
}

stack = []
for s in strng:
    # print(s)
    if s in ['(', '[']:
        stack.append(s)
        continue

    # ')', ']'
    if len(stack) > 0:
        num = 0
        idx = -1
        appendval = -1
        for i in range(len(stack)-1, -1, -1):
            comp = stack[i]
            if comp == dict[s][0]:
                if num>0:
                    appendval = str(num*int(dict[s][1]))
                else:
                    appendval = str(int(dict[s][1]))
                idx = i
                break
            elif not comp.isdigit(): # dict[s][0]이 아닌 다른 문자일 경우 -> 올바르지X
                print(0)
                exit(0)
            else: # 숫자
                num += int(stack[i])
        if idx == -1:
            print(0)
            exit(0)
        while idx != len(stack):
            stack.pop()
        stack.append(appendval)

    else: # 올바르지X괄호열
        print(0)
        exit(0)
    # print(stack)
    # print('----------')

res = 0
for s in stack:
    if s in ['[','(',')',']']:
        print(0)
        exit(0)
    res += int(s)
print(res)