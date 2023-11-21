from itertools import combinations_with_replacement 
def solution(n, info):
    answer = [-1]
    
    lion_info = []
    scores = [0,1,2,3,4,5,6,7,8,9,10]
    
    maxgap = 0

    for scorelist in list(combinations_with_replacement(scores, n)):
        lion, apeach = 0,0
        
        lion_info = [0 for _ in range(11)]
        for s in scorelist:
            lion_info[10-s] +=1
        
        for i in range(11):
            if lion_info[i] == 0 and info[i] == 0:
                continue
            if lion_info[i] > info[i]:
                lion += (10-i)
            else:
                apeach += (10-i)
            
        if lion> apeach:
            if maxgap < (lion-apeach):
                maxgap = lion-apeach
                answer = lion_info
    return answer