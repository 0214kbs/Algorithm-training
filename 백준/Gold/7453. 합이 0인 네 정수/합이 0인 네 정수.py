import sys
input = sys.stdin.readline

n = int(input())
A = []; B= []; C = []; D = []
for _ in range(n):
    a,b,c,d = map(int, input().split())
    A.append(a), B.append(b), C.append(c), D.append(d)
A.sort(); B.sort(); C.sort(); D.sort()

dic = dict()
for a in A:
    for b in B:
        v = a+b
        if v not in dic.keys():
            dic[v] = 1
        else:
            dic[v] +=1

res = 0
for c in C:
    for d in D:
        v = -(c+d)
        if v in dic.keys():
            res+= dic[v]

print(res)