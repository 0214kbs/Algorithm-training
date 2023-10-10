import sys
from collections import defaultdict

input = sys.stdin.readline

dr = [-1,-1,0,1,1,1,0,-1]
dc = [0,1,1,1,0,-1,-1,-1]

N, M, K = map(int, input().split())
fireballs = defaultdict(list)
for i in range(M):
    r,c,m,s,d = map(int, input().split())
    fireballs[(r - 1, c - 1)].append((m, s, d))

 # 1. 모든 파이어볼이 자신의 방향 di로 속력 si칸 만큼 이동
def move():
    global fireballs
    new_fireballs = defaultdict(list)
    for rclist, info_list in fireballs.items():
        sr, sc = rclist
        for m,s,d in info_list:
            nr = (sr + dr[d]*s)%N
            nc = (sc + dc[d]*s)%N
            new_fireballs[(nr,nc)].append((m,s,d))
    fireballs = new_fireballs.copy()

# 2. 이동이 모두 끝난 뒤, 2개 이상의 파이어볼이 있는 칸 - 합치기
def after_move():
    global fireballs
    new_fireballs = defaultdict(list)

    for rclist, info_list in fireballs.items():
        if len(info_list) == 1:
            new_fireballs[rclist].append(info_list[0])
            continue

        sum_m, sum_s, d_list = 0, 0, []
        for m, s, d in info_list:
            sum_m += m
            sum_s += s
            d_list.append(d)

        # 질량이 0인 파이어볼은 소멸되어 없어진다.
        new_m = sum_m // 5
        if new_m == 0:
            continue
        new_s = sum_s // len(info_list)
        new_dirs = [0, 2, 4, 6] if check_dir(d_list) else [1, 3, 5, 7]  # 새로운 파이어볼 방향(all_odd_or_even() 함수의 결과에 따름)
        for new_d in new_dirs:
            new_fireballs[rclist].append((new_m, new_s, new_d))

    fireballs = new_fireballs.copy()


# 합쳐지는 파이어볼의 방향이 모두 홀수이거나 모두 짝수이면, 방향은 0, 2, 4, 6이 되고, 그렇지 않으면 1, 3, 5, 7이 된다.
def check_dir(d_list):
    odd_flag, even_flag = False, False
    for d in d_list:
        if d % 2 == 1:
            odd_flag = True
        if d % 2 == 0:
            even_flag = True

    if odd_flag and even_flag:
        return False
    return True


for _ in range(K):  # k번 반복
    move()
    after_move()

result = 0
for rclist, info_list in fireballs.items():
    for m, s, d in info_list:
        result += m
print(result)