from collections import deque

def solution(queue1, queue2):
    answer = -1
    
    q1 = deque(queue1)
    q2 = deque(queue2)
       
    sum1 = sum(queue1)
    sum2 = sum(queue2)
    
    for i in range(len(queue1)*4+1):
        if sum1 == sum2:
            return i
        elif sum1 < sum2:
            tmp = q2.popleft()
            sum1+= tmp
            sum2-=tmp
            q1.append(tmp)
        else:
            tmp = q1.popleft()
            sum1 -= tmp
            sum2 += tmp
            q2.append(tmp)    
    
    return answer