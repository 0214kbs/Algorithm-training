import sys
input = sys.stdin.readline

left = list(input().rstrip())
right = []
M = int(input())
for _ in range(M):
    # print(left, right)
    order = list(input().rstrip().split())
    if order[0] == 'P':
        left.append(order[1])
    elif order[0] == 'L':
        if left:
            tmp = left.pop()
            right.append(tmp)
    elif order[0] == 'D':
        if right:
            tmp = right.pop()
            left.append(tmp)
    else: # B
        if left:
            left.pop()
print(''.join(left+right[::-1]))