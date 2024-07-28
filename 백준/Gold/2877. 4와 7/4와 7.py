import sys
N = int(sys.stdin.readline())
result =''
while N > 0:
    m = N % 2
    N = N // 2
    if m == 0:
        N -= 1
        result = '7'+ result
    else:
        result = '4'+ result
print(result)