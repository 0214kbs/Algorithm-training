def solution(dirs):
    answer = 0

    UDRL = {
        'U': 0,
        'D': 1,
        'R': 2,
        'L': 3
    }
    drc = [(-1, 0), (1, 0), (0, 1), (0, -1)]
    check = [[[False] * 4 for _ in range(11)] for _ in range(11)]
    # -5 ~ 0 ~ 5 
    # 0   5    10 
    # (0,0) -> (5,5)

    r, c = 5, 5
    for i in dirs:
        d = UDRL[i]
        nr = r + drc[d][0]
        nc = c + drc[d][1]

        # 좌표 밖
        if nr < 0 or nc < 0 or nr > 10 or nc > 10:
            continue

        if i == 'U' and not check[r][c][0] and not check[nr][nc][1]:
            check[r][c][0] = True
            check[nr][nc][1] = True
            answer += 1
        elif i == 'D' and not check[r][c][1] and not check[nr][nc][0]:
            check[r][c][1] = True
            check[nr][nc][0] = True
            answer += 1
        elif i == 'R' and not check[r][c][2] and not check[nr][nc][3]:
            check[r][c][2] = True
            check[nr][nc][3] = True
            answer += 1
        elif i == 'L' and not check[r][c][3] and not check[nr][nc][2]:
            check[r][c][3] = True
            check[nr][nc][2] = True
            answer += 1
        r, c = nr, nc
    return answer