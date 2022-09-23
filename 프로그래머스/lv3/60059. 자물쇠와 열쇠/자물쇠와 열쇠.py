def rotated(key):
    n = len(key)
    new_key = [[0]* n for _ in range(n)]

    for i in range(n):
        for j in range(n):
            new_key[j][n-i-1] = key[i][j]
    return new_key

def check(n,m,board):
    for i in range(n):
        for j in range(n):
            if board[m-1+i][m-1+j] != 1:
                return False 
    return True

def attach(x, y, m, key, board):
    for i in range(m):
        for j in range(m):
            board[x+i][y+j] += key[i][j]

def detach(x, y, m, key, board):
    for i in range(m):
        for j in range(m):
            board[x+i][y+j] -= key[i][j]

def solution(key, lock):
    n = len(lock)
    m = len(key)
    big_lock_length = m*2 + n -2
    big_lock = [[0]*big_lock_length for _ in range(big_lock_length)]
    
    for i in range(n):
        for j in range(n):
            big_lock[m-1+i][m-1+j] = lock[i][j]
    for _ in range(4):
        key = rotated(key)
        for i in range(big_lock_length-m+1):
            for j in range(big_lock_length-m):
                attach(i,j,m,key,big_lock)
                if check(n,m,big_lock):
                    return True
                detach(i,j,m,key,big_lock)
    return False