from collections import deque

def solution(A, K):
    # write your code in Python 3.6
    if len(A) == 0: #A가 empty인 경우를 고려해주어야 함! 
        return A
    q = deque()
    for i in A:
        q.append(i)
    # for i in range(K):
    #     tmp = q.pop()
    #     q.appendleft(tmp)
    K = K%(len(A))
    q.rotate(K)
    # print(q)
    for i in range(len(A)):
        tmp = q.popleft()
        A[i] = tmp
    # print(A)
    return A
