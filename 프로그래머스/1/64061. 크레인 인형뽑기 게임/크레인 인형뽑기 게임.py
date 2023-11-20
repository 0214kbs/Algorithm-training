from collections import deque

def solution(board, moves):
    check = [deque() for _ in range(len(board) + 1)]

    for i in range(len(board)):
        for j in range(len(board)):
            if board[i][j]>0:
                check[j+1].append(board[i][j])
    # print(check);
    
    stack = []
    count = 0
    for m in moves:
        if len(check[m])>0:
            tmp = check[m].popleft()
            if len(stack)>0 and tmp == stack[-1]:
                count+=1
                stack.pop()
            else:
                stack.append(tmp)
    return count*2