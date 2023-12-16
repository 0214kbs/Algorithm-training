import sys

n = int(sys.stdin.readline())
tmp = dict()

for _ in range(n):
    a, b = map(str, sys.stdin.readline().split())

    if b == "enter":
        tmp[a] = b
    else:
        del tmp[a]

tmp = sorted(tmp.keys(), reverse=True)

for i in tmp:
    print(i)