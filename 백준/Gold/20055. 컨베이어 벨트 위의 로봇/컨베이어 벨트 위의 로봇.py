import sys
input = sys.stdin.readline
from collections import deque
N,K = map(int, input().split())
A = deque(list(map(int, input().split())))

robots = []

# 초기 셋팅
step = 0
zero_count = 0

while True:
    if A.count(0) >= K:
        break
    step+=1

    # 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전
    for r in range(len(robots)):
        if robots[r] == N*2-1:
            robots[r] = 0
        else:
            robots[r] += 1

    A.rotate()


    # N번째 로봇 내리기
    if N-1 in robots:
        robots.remove(N-1)

    # 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동
    for i in range(len(robots)):
        index = robots[i]
        if robots[i]+1 == N*2:
            if A[0] > 0 and 0 not in robots:
                robots[i] = 0
                A[0] -= 1
                if A[0] == 0:
                    zero_count+=1
        else:
            if A[index+1] > 0 and robots[i]+1 not in robots:
                robots[i] += 1
                A[index+1] -= 1
                if A[index+1] == 0:
                    zero_count+=1

    # 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
    if A[0] > 0 and 0 not in robots:
        robots.append(0)
        A[0] -= 1
        if A[0] == 0:
            zero_count += 1

    # # N번째 로봇 내리기
    if N-1 in robots:
        robots.remove(N-1)

print(step)