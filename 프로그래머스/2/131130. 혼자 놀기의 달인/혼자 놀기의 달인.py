def solution(cards):
    for i in range(len(cards)):
        cards[i] -= 1
    answer = []
    visited = [False for _ in range(len(cards))]
    
    check = {}
    for i in range(len(cards)):
        if not visited[i]:
            visited[i] =True
            check[i] = [i]
            nxt = cards[i]
            while nxt != i:
                visited[nxt] = True
                check[i].append(nxt)
                nxt = cards[nxt]
            answer.append(len(check[i]))
            
    if len(answer) <2:
        return 0
    else:
        answer.sort()
        
        return answer[-1]*answer[-2]
    
