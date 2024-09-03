def solution(n):
    if n<=2:
        return n
    step1, step2 = 1,2
    for i in range(3,n+1):
        cur = (step1+step2)%1234567
        step1 = step2
        step2 = cur
    return step2