# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")
from collections import defaultdict

def solution(A):
    # write your code in Python 3.6
    A_dict = defaultdict(int)
    for i in A:
        A_dict[i]+=1
    for k,v in A_dict.items():
        if v == 1:
            return k
    
    return -1
