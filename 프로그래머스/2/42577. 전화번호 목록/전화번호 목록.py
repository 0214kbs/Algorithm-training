def solution(phone_book):
    answer = True
    phone_book = sorted(phone_book, key=lambda x: len(x))
    
    phones = {}
    for i in range(len(phone_book)):
        now = phone_book[i]
        for j in range(len(now)):
            if now[:j+1] in phones:
                return False
        phones[now] = now
        
    return answer