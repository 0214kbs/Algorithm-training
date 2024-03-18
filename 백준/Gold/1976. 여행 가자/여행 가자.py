import sys
input = sys.stdin.readline

n= int(input())
m =int(input())

def find(i):
    if parent[i] == i:
        return i
    else:
        parent[i] = parent[parent[i]]
        return parent[i]

def union(i,j):
    a = find(i)
    b = find(j)

    if a == b:
        return
    elif a<b:
        for idx in range(n+1):
            if parent[idx] == a:
                parent[idx] = b
    else:
        parent[b] = a

parent = [i for i in range(n+1)]

for i in range(1,n+1):
    jlist = list(map(int, input().split()))
    for j in range(n):
        if jlist[j] == 1:
            union(min(i,j+1),max(i,j+1))


quest = list(map(int, input().split()))
tmp = parent[quest[0]]
flag = True
for q in range(1, len(quest)):
    if parent[quest[q]] != tmp:
        flag = False
        break
# print(parent)
if flag:
    print('YES')
else:
    print('NO')