from collections import deque

def solution(A, K):
    # write your code in Python 3.6
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
