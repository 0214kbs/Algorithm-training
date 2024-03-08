import sys
from collections import deque
input = sys.stdin.readline
dr = [0,1,0,-1]
dc = [1,0,-1,0]


n, m = map(int, input().split())
board = []
R = [0, 0]
B = [0, 0]
for a in range(n):
    sub = list(input())
    board.append(sub)
    for b in range(m):
        if sub[b] == 'R':
            R = [a, b]
        elif sub[b] == 'B':
            B = [a, b]

FLAG = False
q = deque()
q.append((R[0], R[1], B[0], B[1], 0)) # Rr,Rc,Br,Bc,cnt

visited = set()
visited.add((R[0], R[1], B[0], B[1]))

while q:
    Rr, Rc, Br, Bc, cnt = q.popleft()

    if board[Rr][Rc] == 'O':
        print(cnt)
        FLAG = True
        break

    if cnt >= 10:
        continue

    # R 이동
    for d in range(4):
        r_move = 0
        b_move = 0

        nRr,nRc = Rr + dr[d], Rc + dc[d]

        while True:
            if board[nRr][nRc] == '#':
                nRr -= dr[d]
                nRc -= dc[d]
                break
            elif board[nRr][nRc] == 'O':
                break

            nRr += dr[d]
            nRc += dc[d]

            r_move += 1

        # B 이동
        nBr,nBc = Br + dr[d], Bc + dc[d]
        while True:
            if board[nBr][nBc] == '#':
                nBr -= dr[d]
                nBc -= dc[d]
                break
            elif board[nBr][nBc] == 'O':
                break
            nBr += dr[d]
            nBc += dc[d]
            b_move += 1

        if board[nBr][nBc] == 'O':
            continue

        if (nRr,nRc) == (nBr,nBc):
            if r_move > b_move:
                nRr, nRc = nRr-dr[d], nRc-dc[d]
            else:
                nBr, nBc = nBr-dr[d], nBc-dc[d]

        if not (nRr, nRc, nBr, nBc) in visited:
            visited.add((nRr, nRc, nBr, nBc))
            q.append((nRr, nRc, nBr, nBc, cnt+1))


if not FLAG:
    print(-1)