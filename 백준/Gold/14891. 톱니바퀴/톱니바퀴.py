from collections import deque

T = {}
for i in range(4):
    T[i+1] = deque(map(int, input()))


k = int(input())

def rot_right(idx, td):
    if idx>4 or T[idx-1][2] == T[idx][6]:
        return
    elif T[idx-1][2] != T[idx][6]:
        rot_right(idx+1,-td)
        T[idx].rotate(td)

def rot_left(idx, td):
    if idx<1 or T[idx][2] == T[idx+1][6]:
        return
    elif T[idx][2] != T[idx+1][6]:
        rot_left(idx-1,-td)
        T[idx].rotate(td)

for _ in range(k):
    n, td = map(int, input().split())
    rot_right(n+1,-td)
    rot_left(n-1,-td)
    T[n].rotate(td)

res = 0
for i in range(4):
    res += T[i+1][0] * (2**i)
print(res)