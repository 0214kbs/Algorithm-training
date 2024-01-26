import sys
input = sys.stdin.readline

R,C = map(int, input().split())
map = [['']*C for _ in range(R)]

check = [0]*26
for r in range(R):
    str = input()
    for c in range(C):
        map[r][c] = str[c]


dr = [0,0,-1,1]
dc = [1,-1,0,0]


res = 0
check[ord(map[0][0])-65] = 1
def move(cr,cc,cnt):
    global res
    res = max(res, cnt)

    for d in range(4):
        nr = cr+dr[d]
        nc = cc+dc[d]
        if nr<0 or nc<0 or nr>=R or nc>=C:
            continue
        if check[ord(map[nr][nc])-65] == 1:
            continue
        check[ord(map[nr][nc])-65] = 1
        move(nr,nc,cnt+1)
        check[ord(map[nr][nc]) - 65] = 0


        #print(nr,nc)

move(0,0,1)
print(res)