import sys
from copy import deepcopy
input = sys.stdin.readline

def rotate1():
    for i in range(N):
        arr[i] = new_arr[N-i-1]

def rotate2():
    for i in range(N):
        for j in range(M):
            arr[i][j] = new_arr[i][M-1-j]

def rotate3():
    global arr, N, M
    arr = list(map(list, zip(*arr[::-1])))
    N, M = M, N

def rotate4():
    global arr, N, M
    arr = list(map(list, zip(*arr)))[::-1]
    N, M = M, N

def rotate5():
    global arr
    for i in range(N//2):
        for j in range(M//2):
            arr[i][j] = new_arr[i+N//2][j]
            arr[i][j+M//2] = new_arr[i][j]
            arr[i+N//2][j+M//2] = new_arr[i][j+M//2]
            arr[i+N//2][j] = new_arr[i+N//2][j+M//2]

def rotate6():
    global arr
    for i in range(N//2):
        for j in range(M//2):
            arr[i][j] = new_arr[i][j+M//2]
            arr[i][j+M//2] = new_arr[i+N//2][j+M//2]
            arr[i+N//2][j+M//2] = new_arr[i+N//2][j]
            arr[i+N//2][j] = new_arr[i][j]

N, M, R = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
command = list(map(int, input().split()))


for c in command:
    new_arr = deepcopy(arr)
    if c == 1:
        rotate1()
    elif c == 2:
        rotate2()
    elif c == 3:
        rotate3()
    elif c == 4:
        rotate4()
    elif c == 5:
        rotate5()
    else:
        rotate6()
for a in arr:
    print(*a)