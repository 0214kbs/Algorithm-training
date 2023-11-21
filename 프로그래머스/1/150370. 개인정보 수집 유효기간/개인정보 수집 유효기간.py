def caldeadline(date,time):
    yy,mm,dd = map(int, date.split('.'))
    mm+= time
    dd -=1
    if dd == 0:
        dd = 28
        mm -= 1
    if mm > 12:
        yy+= mm//12
        mm-= (mm//12)*12
        if mm ==0:
            mm = 12
            yy -=1

    # print(yy,mm,dd)
    return yy,mm,dd


def isNeedDelete(today, yy,mm,dd):
    ty,tm,td = map(int, today.split('.'))
    if ty>yy:
        return True
    elif ty<yy:
        return False
    else:
        if tm>mm:
            return True
        elif tm<mm:
            return False
        else:
            if td>dd:
                return True
            else:
                return False
            

def solution(today, terms, privacies):
    answer = []   
    term = {}
    for t in terms:
        a,b = t.split(" ")
        term[a] = int(b)
    
    for i in range(len(privacies)):
        privacy = privacies[i]
        date, termtype = privacy.split(" ")
        yy,mm,dd = caldeadline(date,term[termtype])
        if(isNeedDelete(today,yy,mm,dd)):
            answer.append(i+1)
    return answer