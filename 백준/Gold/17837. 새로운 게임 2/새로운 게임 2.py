n, k = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
chess = [[[] for _ in range(n)] for _ in range(n)]
dr = [0, 0, -1, 1]
dc = [1, -1, 0, 0]
horse = []

for i in range(k):
    r, c, d = map(int, input().split())
    horse.append([r-1, c-1, d-1])
    chess[r-1][c-1].append(i)

count = 0

def change_dir(d):
    if d in [0, 2]:
        d += 1
    elif d in [1, 3]:
        d -= 1
    return d

def move_h(h_num):
    r, c, d = horse[h_num]
    nr = r + dr[d]
    nc = c + dc[d]
    if 0 > nr or nr >= n or 0 > nc or nc >= n or board[nr][nc] == 2:
        d = change_dir(d)
        horse[h_num][2] = d
        nr = r + dr[d]
        nc = c + dc[d]
        if 0 > nr or nr >= n or 0 > nc or nc >= n or board[nr][nc] == 2:
            return True

    horse_up = []
    for h_idr, h_n in enumerate(chess[r][c]):
        if h_n == h_num:
            horse_up.extend(chess[r][c][h_idr:])
            chess[r][c] = chess[r][c][:h_idr]
            break

    if board[nr][nc] == 1:
        horse_up = horse_up[-1::-1]

    for h in horse_up:
        horse[h][0], horse[h][1] = nr, nc
        chess[nr][nc].append(h)

    if len(chess[nr][nc]) >= 4:
        return False
    return True

while True:
    what = False
    if count > 1000:
        print(-1)
        break
    for i in range(k):
        if move_h(i) == False:
            what = True
            break
    count += 1
    if what:
        print(count)
        break