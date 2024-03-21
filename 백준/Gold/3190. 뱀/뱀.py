import sys
input = sys.stdin.readline

drc = [(0,1),(1,0),(0,-1),(-1,0)]

n = int(input())
k = int(input())
apple = []
for _ in range(k):
    a,b = map(int,input().split())
    apple.append([a-1,b-1])
l = int(input())
turn_r = []
turn_l = []
for _ in range(l):
    a,b =input().split()
    if b=='D':
        turn_r.append(int(a))
    else:
        turn_l.append(int(a))

head = [0,0]
tail = [0,0]

visit = [[0]*n for _ in range(n)]
time = 0
d = 0 # 현재 방향
visit[0][0] = 1

while True:
    # print(time, head, tail,d)
    if time in turn_r:
        d +=1
        d %=4
    elif time in turn_l:
        d-=1
        d %= 4
    # move
    nr,nc = head[0]+drc[d][0],head[1]+drc[d][1]
    if nr<0 or nc<0 or nr>=n or nc>=n: # 벽
        # print('벽',nr,nc)
        break
    if visit[nr][nc]>0 and visit[tail[0]][tail[1]] <= visit[nr][nc]:
        # print('몸',nr,nc,tail)
        break # 몸

    if [nr,nc] in apple:
        # print('apple!',nr,nc)
        visit[nr][nc]= visit[head[0]][head[1]]+1
        head = [nr,nc]
        apple.remove([nr,nc])
    else:
        visit[nr][nc]= visit[head[0]][head[1]]+1
        head = [nr,nc]
        for dr,dc in drc:
            checkr,checkc = tail[0]+dr, tail[1]+dc
            # # print('here',visit[0])
            if checkr<0 or checkc<0 or checkr>=n or checkc>=n:
                continue
            if visit[checkr][checkc] == visit[tail[0]][tail[1]]+1:
                tail = [checkr,checkc]
                break
    time+=1

print(time+1)