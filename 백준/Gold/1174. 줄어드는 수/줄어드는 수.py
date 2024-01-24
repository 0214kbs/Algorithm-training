N  = int(input())

res = []

def bt(cur):
    res.append(int(cur))
    for j in range(int(cur[-1])):
        bt(cur+str(j))

if N>1023:
    print(-1)
else:
    for i in range(10):
        bt(str(i))
        res.sort()
    print(res[N-1])