# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A):
    # write your code in Python 3.6
    A = sorted(A) 
    
    for i in range(0,len(A),2):
        if i+1 == len(A): # 가장 마지막에 있는 경우 생각!
            return A[i]
        if A[i] != A[i+1]:
            return A[i]
