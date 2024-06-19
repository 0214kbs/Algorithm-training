def solution(progresses, speeds):
    answer = []
    
    day = 0
    for i in range(len(progresses)):
        progress = progresses[i]
        speed = speeds[i]
        
        need = (100-progress)//speed
        if (100-progress)%speed>0:
            need +=1
        
        if day<need:
            day = need
            answer.append(1)
        else:
            answer[-1] += 1
        
    return answer