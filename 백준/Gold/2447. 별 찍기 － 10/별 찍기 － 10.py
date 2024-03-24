import sys
sys.setrecursionlimit(10 ** 6)

def func(length):
    if length == 1:
        return ['*']

    stars =  func(length//3)
    tmp = []

    for s in stars:
        tmp.append(s*3)
    for s in stars:
        tmp.append(s+' '*(length//3)+s)
    for s in stars:
        tmp.append(s*3)
    return tmp

n = int(input())
print('\n'.join(func(n)))