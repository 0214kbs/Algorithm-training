from collections import deque

def move(cur):
    data = []
    tmp = cur
    for _ in range(time[cur]+1):
        data.append(tmp)
        tmp = visit[tmp]
    print(' '.join(map(str, data[::-1])))


n,k = map(int, input().split())
time = [0]*100001 # 초
visit = [0]*100001 # 좌표

q = deque()
q.append(n)
res = 0
while q:
    cur =q.popleft()
    if cur == k:
        print(time[cur])
        move(cur)
        break
    for nxt in (cur-1,cur+1,cur*2):
        if 0<=nxt<=100000 and time[nxt] == 0:
            time[nxt] = time[cur]+1
            q.append(nxt)
            visit[nxt] =cur