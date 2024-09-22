def solution(answers):
    supo = [[],[1, 2, 3, 4, 5],[2, 1, 2, 3, 2, 4, 2, 5],[ 3, 3, 1, 1, 2, 2, 4, 4, 5, 5]]
    sums = [0 for _ in range(4)]    
    for ai in range(len(answers)):
        cur = answers[ai]
        for i in range(1,4):
            if supo[i][ai%len(supo[i])] == cur:
                sums[i]+=1
    maxi = sums[1]
    answer = [1]
    for i in range(2,4):
        if maxi < sums[i]:
            answer = [i]
            maxi = sums[i]
        elif maxi == sums[i]:
            answer.append(i)
    return answer