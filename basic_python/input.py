# 한 줄 통째로 입력받아 a에 문자열로 저장
a = input()  # '11 22 33'

# int형으로 형변환
b = int(input())

c = input().split()  # '11,22,33' -> ['11,'22','33']

d = map(int, input().split())  # 객체 반환됨. 따라서 하나하나 따로 저장해주거나 리스트 변환이 필요함
e, f, g = map(int, input().split())
h = list(map(int, input().split()))

# Variadic parameters(가변인자)
# 5 1 2 3 4 5 : n = 5이고 [1,2,3,4,5] 입력
n, *l = map(int, input().split())
print(l)

# 여러개의 test case
while True:
    N, *L = map(int, input().split())
    if N == 0:
        break
    print(L)

# [0,0,0,0,0]
arr1 = [0 for _ in range(5)]

# n x m 배열
n = 2
m = 5
arr2 = [[0]*m for _ in range(n)]

# 5줄에 걸쳐 A, B, C, D, E 입력
A, B, C, D, E = [int(input()) for _ in range(5)]

# 2차원 배열 입력받기
N, M = map(int,input().split())
# 공백없이
arr3 = [list(map(int,input()))for _ in range(N)]
# 공백 있이
arr4 = [list(map(int, input().split()))for _ in range(N)]
