def solution(n, lost, reserve):
    
    removes = []
    for l in lost:
        for r in reserve:
            if l == r:
                removes.append(l)
    for r in removes:
        lost.remove(r)
        reserve.remove(r)
    lost.sort()
    reserve.sort()
    
    cnt = 0
    li, ri = 0,0
    while True:
        if li== len(lost) or ri == len(reserve):          
            break
        
        if abs(reserve[ri] -lost[li]) == 1:
            ri +=1
            li += 1
            cnt += 1
        else:
            if reserve[ri] > lost[li]:
                li += 1
            else:
                ri += 1
                
    answer = n-len(lost)+cnt
    return answer