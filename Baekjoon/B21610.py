import sys


# 모든 구름이 di 방향으로 si칸 이동한다.
# 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가한다.
def cloud_move(i, si):
    # cnt = 0 # 구름 개수
    # print("clouds")
    # print(clouds)
    for r in range(n):
        for c in range(n):
            if clouds[r][c] == 1:  # 구름이 있는경우
                clouds[r][c] = 0  # 기존 구름
                nx = r + (dx[i] * si)
                ny = c + (dy[i] * si)
                # cnt += 1
                # 경계 넘어가는 경우
                while True:
                    if 0<=nx<n and 0<=ny<n:
                        break
                    if nx > n - 1:
                        nx = nx - n
                    if nx < 0:
                        nx = nx + n
                    if ny > n - 1:
                        ny = ny - n
                    if ny < 0:
                        ny = ny + n

                maps[nx][ny] += 1
                copy_clouds[nx][ny] = 1
    # print(cnt)


# 2에서 물이 증가한 칸 (r, c)에 물복사버그 마법을 시전한다.
# 물복사버그 마법을 사용하면, 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수만큼 (r, c)에 있는 바구니의 물이 양이 증가한다.
def magic_copy():
    # print("copy clouds")
    # print(copy_clouds)
    for r in range(n):
        for c in range(n):
            sum = 0
            if copy_clouds[r][c] == 1:  # 2에서 물이 증가한 칸
                if 0 <= (r + 1) < n and 0 <= (c - 1) < n and maps[r + 1][c - 1] > 0:
                    sum += 1
                if 0 <= (r + 1) < n and 0 <= (c + 1) < n and maps[r + 1][c + 1] > 0:
                    sum += 1
                if 0 <= (r - 1) < n and 0 <= (c + 1) < n and maps[r - 1][c + 1] > 0:
                    sum += 1
                if 0 <= (r - 1) < n and 0 <= (c - 1) < n and maps[r - 1][c - 1] > 0:
                    sum += 1
                maps[r][c] += sum


# 바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다.
# 이때 구름이 생기는 칸은 3에서 구름이 사라진 칸이 아니어야 한다. (사라진 구름 : 옮긴 구름)
def make_clouds():
    for r in range(n):
        for c in range(n):
            if (maps[r][c] >= 2) and (copy_clouds[r][c] == 0):
                clouds[r][c] = 1
                maps[r][c] -= 2


input = sys.stdin.readline
maps = []
clouds = []
copy_clouds = []  # 물복사 마법을 위한 clouds
n, m = map(int, input().split())

# 방향 정의 (i+1)
dx = [0,-1,-1,-1,0,1,1,1]
dy = [-1, -1, 0, 1, 1, 1, 0, -1]

for _ in range(n):
    maps.append(list(map(int, input().split())))

# 구름 초기 위치
clouds = [[0] * n for i in range(n)]
clouds[n - 1][0] = 1
clouds[n - 1][1] = 1
clouds[n - 2][0] = 1
clouds[n - 2][1] = 1
copy_clouds = [[0] * n for i in range(n)]

for i in range(m):
    di, si = map(int, input().split())
    # print("si")
    # print(si)
    # 1,2
    cloud_move(di - 1, si)
    # print(maps)
    # 3
    clouds = [[0] * n for j in range(n)]
    # 4
    magic_copy()
    # print(maps)
    # 5
    make_clouds()
    # print(maps)
    copy_clouds = [[0] * n for i in range(n)]

water_sum = 0
for r in range(n):
    for c in range(n):
        water_sum += maps[r][c]
# print(maps)
print(water_sum)