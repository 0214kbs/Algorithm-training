def hanoi_top(n, a, b, c):
    if n == 1:
        print(a, c)
    else:
        hanoi_top(n - 1, a, c, b)
        print(a, c)
        hanoi_top(n - 1, b, a, c)


n = int(input())
print(2**n-1)
hanoi_top(n, 1, 2, 3)
