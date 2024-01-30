import sys
input = sys.stdin.readline

def test(cur):

    global cnt,res, tmp
    if cnt == 11:
        #print(check)
        res= max(res,tmp)
    if cur == 11:
        return
    for i in range(11):
        if board[cur][i]>0:
            if check[i] == 0:
                check[i] = cur+1
                cnt += 1
                tmp += board[cur][i]
                test(cur+1)
                check[i] = 0
                cnt -= 1
                tmp -= board[cur][i]

T = int(input())
for _ in range(T):
    board = [[0]]*11

    for i in range(11):
        board[i] = list(map(int, input().split()))

    check = [0] * 11
    cnt = 0
    res = 0
    tmp = 0

    test(0)
    print(res)