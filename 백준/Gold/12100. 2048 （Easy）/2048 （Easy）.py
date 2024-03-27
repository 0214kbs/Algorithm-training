import sys,copy
input = sys.stdin.readline

def right(board):
    for r in range(n):
        cursor = n-1
        for c in range(n-2,-1,-1):
            if board[r][c]>0:
                tmp = board[r][c]
                board[r][c] = 0
                if board[r][cursor] == 0:
                    board[r][cursor] = tmp
                elif board[r][cursor] == tmp:
                    board[r][cursor] += tmp
                    cursor-=1
                else:
                    cursor-=1
                    board[r][cursor] = tmp
    return board

def left(board):
    for r in range(n):
        cursor = 0
        for c in range(1, n):
            if board[r][c]>0:
                tmp = board[r][c]
                board[r][c] = 0
                if board[r][cursor] == 0:
                    board[r][cursor] = tmp
                elif board[r][cursor] == tmp:
                    board[r][cursor] += tmp
                    cursor+=1
                else:
                    cursor+=1
                    board[r][cursor] =tmp
    return board

def down(board):
    for c in range(n):
        cursor = n-1
        for r in range(n-2,-1,-1):
            if board[r][c]>0:
                tmp = board[r][c]
                board[r][c] = 0
                if board[cursor][c] == 0:
                    board[cursor][c] = tmp
                elif board[cursor][c] == tmp:
                    board[cursor][c] += tmp
                    cursor-=1
                else:
                    cursor-=1
                    board[cursor][c] = tmp
    return board

def up(board):
    for c in range(n):
        cursor = 0
        for r in range(1,n):
            if board[r][c] > 0:
                tmp = board[r][c]
                board[r][c] = 0
                if board[cursor][c] == 0:
                    board[cursor][c] = tmp
                elif board[cursor][c] == tmp:
                    board[cursor][c] += tmp
                    cursor += 1
                else:
                    cursor += 1
                    board[cursor][c] = tmp
    return board


def dfs(turn, arr):
    global res
    if turn == 5:
        for i in range(n):
            for j in range(n):
                if arr[i][j] >res:
                    res = arr[i][j]
        return
    for i in range(4):
        copy_arr = copy.deepcopy(arr)
        if i == 0:
            dfs(turn+ 1, left(copy_arr))
        elif i == 1:
            dfs(turn+ 1, right(copy_arr))
        elif i == 2:
            dfs(turn+ 1, up(copy_arr))
        else:
            dfs(turn+ 1, down(copy_arr))

n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]
res = 0
dfs(0,board)
print(res)