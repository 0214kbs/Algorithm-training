from itertools import product

def solution(users, emoticons):
    answer = [0,0]
    
    arr = [40,30,20,10]
    for p in product(arr, repeat=len(emoticons)):
        # print(p)
        plus = 0
        salePrice = 0 
        for user in users: # 각 사용자
            percent, price = user[0], user[1]
            buy = 0
            for i in range(len(emoticons)):
                if p[i]>=percent:
                    buy += emoticons[i] * (100-p[i])//100
            if buy >= price:
                plus += 1
                buy = 0
            else:
                salePrice += buy
        # print(answer, plus, salePrice)
        if answer[0] <plus:
            answer[0] = plus
            answer[1] = salePrice
        elif answer[0] == plus:
            if answer[1] < salePrice:
                answer[1] = salePrice
                
          
    return answer