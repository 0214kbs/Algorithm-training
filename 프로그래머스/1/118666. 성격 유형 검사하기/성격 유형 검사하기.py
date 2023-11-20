dict = {
    "R": (0, 0),
    "T": (0, 1),
    "C": (1, 0),
    "F": (1, 1),
    "J": (2, 0),
    "M": (2, 1),
    "A": (3, 0),
    "N": (3, 1),
}

def solution(survey, choices):
    answer = ''
    
    board =  [[0 for _ in range(2)] for _ in range(4)]
    # print(board)
    for i in range(len(survey)):
        if choices[i]<4:
            r,c = dict[survey[i][0]]
            board[r][c] += (4-choices[i])
        elif choices[i]>4:
            r,c = dict[survey[i][1]]
            board[r][c] += (choices[i]-4)
        # print(board)
    if board[0][0] < board[0][1]:
            answer+= 'T'
    else:
            answer+= 'R'
    if board[1][0] < board[1][1]:
            answer+= 'F'
    else:
            answer+= 'C'
    if board[2][0] < board[2][1]:
            answer+= 'M'
    else:
            answer+= 'J'
    if board[3][0] < board[3][1]:
            answer+= 'N'
    else:
            answer+= 'A'
    return answer