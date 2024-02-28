import sys
input = sys.stdin.readline

n,c = map(int, input().split())
m = int(input())
info = []
for i in range(m):
    send, get, boxes =  map(int, input().split())
    info.append([send,get,boxes])

info.sort(key=lambda x:x[1])

truck_c = [c]*(n+1)
res = 0

for i in range(m):
    tmp = c
    for j in range(info[i][0], info[i][1]):
        tmp = min(tmp, truck_c[j])
    tmp = min(tmp, info[i][2])

    for k in range(info[i][0], info[i][1]):
        truck_c[k] -= tmp

    res += tmp

print(res)