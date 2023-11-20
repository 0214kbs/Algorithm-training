dict = {
    "1": (0, 0),
    "2": (0, 1),
    "3": (0, 2),
    "4": (1, 0),
    "5": (1, 1),
    "6": (1, 2),
    "7": (2, 0),
    "8": (2, 1),
    "9": (2, 2),
    "*": (3, 0),
    "0": (3, 1),
    "#": (3, 2),
}


def solution(numbers, hand):
    answer = ''

    cur_l = (3,0)
    cur_r = (3,2)
    
    for n in numbers:
        if n in [1,4,7] or str(n) == '*':
            cur_l = dict[str(n)]
            answer+='L'
        elif n in [3,6,9] or str(n) == '#':
            cur_r = dict[str(n)]
            answer+='R'
        else:
            nr,nc = dict[str(n)]
            lr, lc = cur_l
            rr, rc = cur_r
            
            distL = abs(nr-lr)+abs(nc-lc)
            distR = abs(nr-rr)+abs(nc-rc)
            
            if distL < distR:
                cur_l = dict[str(n)]
                answer+='L'
            elif distL > distR:  
                cur_r = dict[str(n)]
                answer+='R'
                
            else:
                if hand == "right":
                    cur_r = dict[str(n)]
                    answer+='R'
                else:
                    cur_l = dict[str(n)]
                    answer+='L'
    return answer