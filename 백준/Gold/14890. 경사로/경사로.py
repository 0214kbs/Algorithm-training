import sys
input = sys.stdin.readline

n,l = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

res = 0
for i in range(n):
    line = board[i]
    compare = line[0] #비교 해야되는 값
    PASS = True
    DOWN = False

    check = [0 for _ in range(11)]
    # # print(line)
    for j in range(n):
        # # print(check)
        if line[j] == compare:
            check[line[j]]+=1
            if DOWN and check[line[j]] >= l:
                DOWN = False
                check[line[j]] = 0
                compare =line[j]
        else:
            if DOWN:
                # print(line,'down 문제')
                PASS = False
                break
            if line[j]-compare ==1 and check[compare] >=l: # 오르막길일때
                compare = line[j]
                check[compare] = 0
                check[line[j]] +=1
            elif not DOWN and line[j]-compare == -1: # 내리막길이고 이후 line[j] 높이의 개수가 l 개 인지 확인하기
                if l==1:
                    check[compare] = 0
                    compare= line[j]
                    check[line[j]] = 0
                else:
                    DOWN = True
                    check[compare] = 0
                    compare = line[j]
                    check[line[j]] += 1
            else:
                # print(line)
                PASS = False
                break
    if DOWN and PASS:
        # print(line,'down이 켜져있어서')
        PASS = False
    if PASS:
        res+=1

# print('---------')
for i in range(n):
    line = []
    for j in range(n):
        line.append(board[j][i])
    compare = line[0]  # 비교 해야되는 값
    PASS = True
    DOWN = False

    check = [0 for _ in range(11)]
    for j in range(n):
        if line[j] == compare:
            check[line[j]] += 1
            if DOWN and check[line[j]] >= l:
                DOWN = False
                check[line[j]] = 0
                compare = line[j]
        else:
            if DOWN:
                # print( line, 'down 문제')
                PASS = False
                break
            if line[j] - compare == 1 and check[compare] >= l:  # 오르막길일때
                compare = line[j]
                check[compare] = 0
                check[line[j]] += 1
            elif not DOWN and line[j] - compare == -1:  # 내리막길이고 이후 line[j] 높이의 개수가 l 개 인지 확인하기
                if l == 1:
                    check[compare] = 0
                    compare = line[j]
                    check[line[j]] = 0
                else:
                    DOWN = True
                    check[compare] = 0
                    compare = line[j]
                    check[line[j]] += 1
            else:
                # print(line)
                PASS = False
                break
    if DOWN and PASS:
        # print(line,'down이 켜져있어서')
        PASS = False
    if PASS:
        res+=1

print(res)