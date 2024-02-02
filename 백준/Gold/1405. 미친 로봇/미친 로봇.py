N,EP,WP,SP,NP = map(int, input().split())
prob = [EP/100,WP/100,SP/100,NP/100]

res = 0
dr = [0,0,1,-1]
dc = [1,-1,0,0]

def move(r,c,visited,tmp,cnt):
    global res
    visited.append([r,c])

    for d in range(4):
        nr = r+dr[d]
        nc = c+dc[d]
        if prob[d] == 0:
            continue
        if [nr,nc] in visited:
            continue
        if cnt+1 == N:
            # print(tmp)
            res += tmp*prob[d]
            continue
        move(nr,nc,visited,tmp*prob[d],cnt+1)
        visited.pop()


move(14,14,[],1,0)
print(res)