import sys
input = sys.stdin.readline

N = int(input())
map = [list(map(int, input().split())) for _ in range(N)]

# 1 ~ N-2 중심 가능
lst = []
for r in range(1,N-1):
    for c in range(1,N-1):
        lst.append([r,c])

res = 1e9

dr = [0,0,-1,1]
dc = [1,-1,0,0]

def calc(rclist):
    global res
    price = 0
    visited = [[False]*N for _ in range(N)]
    for r,c in rclist:
        price += map[r][c]
        visited[r][c] = True
        for d in range(4):
            tr = r+dr[d]
            tc = c+dc[d]
            if tr<0 or tr>=N or tc<0 or tc>=N:
                continue
            if visited[tr][tc]:
                return
            visited[tr][tc] = True
            price += map[tr][tc]

    if price < res:
        res = price



tmp = [0]*3
def comb(L,BW):
    if L == 3:
        # print(tmp)
        calc(tmp)
    else:
        for i in range(BW,len(lst)):
            tmp[L] = lst[i]
            comb(L+1,i+1)

comb(0,0)

print(res)