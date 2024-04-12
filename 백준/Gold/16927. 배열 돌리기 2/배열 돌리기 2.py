from collections import deque

N, M, R = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
drc = [[1, 0], [0, 1], [-1, 0], [0, -1]]

def rotate():
    q = deque()
    for start in range(min(N, M) // 2):
        r = c = start

        for dr, dc in drc:
            while True:
                nr,nc = r + dr, c + dc
                if start <= nr < N - start and start <= nc < M - start:
                    q.append(arr[r][c])
                    r,c = nr,nc
                else:
                    break

        for _ in range(R % ((N - start * 2) * 2 + (M - start * 2) * 2 - 4)):
            q.appendleft(q.pop())

        for dr, dc in drc:
            while True:
                nr,nc = r + dr, c + dc
                if start <= nr < N - start and start <= nc < M - start:
                    arr[r][c]=q.popleft()
                    r,c = nr,nc
                else:
                    break

rotate()

for i in range(N):
    print(*arr[i])