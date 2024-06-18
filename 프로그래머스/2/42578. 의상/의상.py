def solution(clothes):
    answer = 1
    
    clothes_dict ={}
    for name, ctype in clothes:
        if ctype not in clothes_dict:
            clothes_dict[ctype] = [name]
        else:
            clothes_dict[ctype].append(name)
    
    for ctype in clothes_dict.keys():
        cnt = len(clothes_dict[ctype])
        answer *= (cnt+1)
    answer -= 1
    return answer