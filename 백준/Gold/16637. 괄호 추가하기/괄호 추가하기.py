import sys

n = int(input())
s = input()
res = -1 * 1e9

def operation(n1, oper, n2):
    if oper == '+':
        return n1 + n2
    if oper == '-':
        return n1 - n2
    if oper == '*':
        return n1 * n2

def dfs(index, value):
    global res

    if index == n - 1:
        res = max(res, value);
        return

    if index + 2 < n:
        dfs(index + 2, operation(value, s[index + 1], int(s[index + 2])))

    if index + 4 < n:
        dfs(index + 4, operation(value, s[index + 1], operation(int(s[index + 2]), s[index + 3], int(s[index + 4]))))


dfs(0, int(s[0]))
print(res)