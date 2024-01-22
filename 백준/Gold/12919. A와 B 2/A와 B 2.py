import sys

S = input()
T = input()

def dfs(T):
    if S==T:
        print(1)
        sys.exit()
    if len(T) == 0:
        return 0
    if T[-1] == 'A':
        dfs(T[:-1])
    if T[0] == 'B':
        dfs(T[1:][::-1])

dfs(T)
print(0)