def solution(N):
    # write your code in Python 3.6
    binary_num = bin(N)
    binary_num = binary_num [2:] # 0b1010 과 같은 형태이므로 
    cnt = 0
    zero_cnt = 0
    max = 0
    for i in binary_num:
        if i == '1':
            cnt+=1
        elif i == '0':
            zero_cnt +=1
        if cnt == 2:
            if zero_cnt>max:
                max = zero_cnt
            cnt = 1
            zero_cnt = 0
    return max
