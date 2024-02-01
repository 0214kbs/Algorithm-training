import sys
input = sys.stdin.readline

N,M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

visited = [[False]*M for _ in range(N)]
drc = [[0,-1,1,0],[0,-1,-1,0],[-1,0,0,1],[1,0,0,1]]

if N<2 or M<2:
    print(0)
    exit(0)

res = 0
def check(i,j,tmp):
    global res
    if j==M:
        i+=1
        j=0
    if i==N:
        res = max(res,tmp)
        # print('here',res)
        return
    if not visited[i][j]:
        for d in range(4):
            nr1 = drc[d][0]+i
            nc1 = drc[d][1]+j
            nr2 = drc[d][2]+i
            nc2 = drc[d][3]+j

            if nr1<0 or nr1>=N or nr2<0 or nr2>=N:
                continue
            if nc1<0 or nc1>=M or nc2<0 or nc2>=M:
                continue
            if visited[nr1][nc1] or visited[nr2][nc2]:
                continue
            visited[nr1][nc1] = visited[nr2][nc2] = visited[i][j] = True
            check(i,j+1,tmp+board[i][j]*2+board[nr1][nc1]+board[nr2][nc2])
            visited[nr1][nc1] = visited[nr2][nc2] = visited[i][j] = False
    check(i,j+1,tmp)

check(0,0,0)

print(res)