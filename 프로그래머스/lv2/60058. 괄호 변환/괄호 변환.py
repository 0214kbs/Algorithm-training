def check_bal(w):
    stack = []
    for c in w:
        if c == "(":
            stack.append(c)
        elif c==")" and len(stack)!=0:
            stack.pop()
        else:
            return 0 # 균형 잡히지 X
    return 1

def split_w(w):
    check_1 = 0 # ( 개수
    check_2 = 0 # ) 개수
    i=0
    while True:
        if check_1 == check_2 and check_1 != 0:
            break
        if w[i] == "(":
            check_1 +=1
        else: # ")" 
            check_2 +=1
        i+=1
    return w[:check_1*2],w[check_1*2:]

def makeCorrect(w):
    if len(w) == 0:
        return w
    u,v=split_w(w)
    if check_bal(u)==0: # 올바른 문자열이 아니라면
        res ="("
        res += makeCorrect(v)
        res += ")"

        u = u[1:-1]
        for c in u:  
            if c == "(":
                res+=")"
            else:
                res+="("
        return res
    else:
        return u+makeCorrect(v)


def solution(p):
    
    if len(p)==0:
        return p
    if check_bal(p)==1: #balance
        return p
#else
    return makeCorrect(p)
    
