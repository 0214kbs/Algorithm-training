# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A):
    # write your code in Python 3.6
    A=sorted(A)
    cnt = 1
    for i in A:
        if i==cnt:
            cnt +=1
        elif i<cnt:
            pass
        elif i<0:
            pass
        else:
            return cnt
    if cnt == 1 :
        return 1
    else:
        return A[len(A)-1]+1
