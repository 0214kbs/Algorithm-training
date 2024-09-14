def solution(prices):
    answer = [0 for _ in range(len(prices))]
    
    stack = []
    for i in range(len(prices)):
        
        for s in stack:
            si, sv = s[0], s[1]
            answer[si] +=1
        while stack and stack[-1][1] > prices[i]:
            stack.pop()
        stack.append((i, prices[i]))
    return answer