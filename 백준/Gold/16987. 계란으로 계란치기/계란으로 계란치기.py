N = int(input())
s = [0]*N
w = [0]*N
for i in range(N):
    s[i],w[i] = map(int, input().split())

res = 0
def bt(idx, eggs):

    global res
    if idx == N:
        cnt = 0
        for i in range(N):
            if eggs[i]<=0:
                cnt +=1
        res = max(cnt, res)
        return

    if eggs[idx]>0: # 깨지지 않으면
        for i in range(N):
            flag = False
            if eggs[i] >0 and i != idx:
                flag = True
                tmpeggs = eggs[:]
                tmpeggs[idx] -= w[i]
                tmpeggs[i] -= w[idx]
                bt(idx+1, tmpeggs)
        if not flag:
            bt(idx+1, eggs)
    else:
        bt(idx+1, eggs)


bt(0,s)
print(res)