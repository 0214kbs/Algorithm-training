import sys
input = sys.stdin.readline

# 1->3으로 n개 옮기기
def hanoi_top(n, start, mid, to):
    if n == 1:
        print(start, to)
    else:
        # 1->2로 n-1개 옮기기
        hanoi_top(n - 1, start, to, mid)
        # 1 -> 3로 가장 큰 원판을 옮기고,
        print(start, to)
        # 2->3 n-1개 옮기기
        hanoi_top(n - 1, mid, start, to)


n = int(input())
print(2**n-1)
hanoi_top(n, 1, 2, 3)