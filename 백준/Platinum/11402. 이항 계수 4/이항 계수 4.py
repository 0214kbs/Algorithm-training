import sys
input = sys.stdin.readline
N, K, M = map(int, input().split())

def lucas_theorem(n, k, m):
    def factorial(n):
        result = 1
        for i in range(1, n + 1):
            result *= i
        return result
    def power(a, b, m):
        result = 1
        while b > 0:
            if b % 2 == 1:
                result = (result * a) % m
            a = (a * a) % m
            b //= 2
        return result
    def lucas(n, k, m):
        result = 1
        while n > 0 or k > 0:
            n_i = n % m
            k_i = k % m
            if n_i < k_i:
                return 0
            result = (result * factorial(n_i) * power(factorial(k_i) * factorial(n_i - k_i), m-2, m)) % m
            n //= m
            k //= m
        return result
    return lucas(n, k, m)

res = lucas_theorem(N, K, M)
print(res)