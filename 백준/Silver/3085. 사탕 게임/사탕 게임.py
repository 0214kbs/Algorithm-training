import sys
input = sys.stdin.readline
n = int(input())
board = [list(input()) for _ in range(n)]
res = 1

def calc(board):
    maxcnt = 1
    for i in range(n):
        cnt = 1
        for j in range(n-1):
            if(board[i][j] == board[i][j+1]):
                cnt+=1
                maxcnt = max(cnt,maxcnt)
            else:
                cnt = 1
                # if (n-j-1) > cnt or (n-j-1) > maxcnt :
                #     break
        
        cnt = 1
        for j in range(n-1):
            if(board[j][i] == board[j+1][i]):
                cnt+=1
                maxcnt = max(maxcnt, cnt)   
            else:
                cnt = 1
                # if (n-j-1) > cnt or (n-j-1) > maxcnt :
                #     break
    return maxcnt 
        

# 노가다 
for i in range(n):
    for j in range(n):
        if j<n-1:
            board[i][j], board[i][j+1] = board[i][j+1], board[i][j]
            tmp =  calc(board)
            res = max(res, tmp)
            board[i][j], board[i][j+1] = board[i][j+1], board[i][j]
        if i<n-1:
            board[i][j], board[i+1][j] = board[i+1][j],board[i][j]
            tmp = calc(board)
            res = max(res,tmp)
            board[i][j], board[i+1][j] = board[i+1][j],board[i][j]
            
print(res)