import math
def isPrime(x):
    if x==1:
        return False
    for i in range(2, int(math.sqrt(x)) + 1):
        if x % i == 0:
            return False
    return True

def tenToN(n, k):
    rev_base = ''
    while n > 0:
        n, mod = divmod(n, k)
        rev_base += str(mod)
    return rev_base[::-1] 

def solution(n, k):
    answer = 0
    value = tenToN(n, k)
    str = ''
    for v in value:
        if v == '0':           
            if len(str)>0:
                if isPrime(int(str)):
                    answer+=1
            str = ''                
        else:
            str+=v
    if len(str)>0:
        if isPrime(int(str)):
            answer+=1
    return answer