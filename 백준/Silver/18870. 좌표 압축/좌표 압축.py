import sys
input = sys.stdin.readline

def find(x,start,end):
    mid = (start+end)//2
    if x < unique[mid]:
        return find(x, start, mid-1)
    elif x > unique[mid]:
        return find(x, mid+1, end)
    else:
        return mid

N = int(input())
xlist = list(map(int, input().split()))
tmp = sorted(xlist)
unique = []
for t in tmp:
    if len(unique) == 0:
        unique.append(t)
    else:
        if unique[-1] != t:
            unique.append(t)

res = [0 for _ in range(N)]
for i in range(N):
    res[i] = find(xlist[i],0, len(unique))
print(*res)
