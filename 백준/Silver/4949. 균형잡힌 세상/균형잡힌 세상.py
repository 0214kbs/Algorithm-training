def push(stack, x):
    stack.append(x)


def pop(stack):
    stack.pop()


def top(stack):
    return stack[-1] if stack else -1


while True:
    string = input()
    if string == '.':
        break
    else:
        stack = []
        print_value = True

        for c in string:
            if c in '[(':
                # stack.append(c)
                push(stack, c)
                # print(stack)
            elif c == ']':
                if top(stack) == '[' and len(stack) != 0:
                    # stack.pop()
                    pop(stack)
                    # print(stack)
                else:
                    stack.append(']')
                    break
            elif c == ')':
                if top(stack) == '(' and len(stack) != 0:
                    # stack.pop()
                    pop(stack)
                    # print(stack)
                else:
                    stack.append(')')
                    break
        if len(stack) == 0:
            print("yes")
        else:
            print("no")
