import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**5)
def dfs(i):
    tree[i] = -10
    for j in range(n):
        if i == tree[j]:
            dfs(j)

n = int(input())
tree = list(map(int, input().split()))
erase = int(input())
# print(tree)

dfs(erase)
cnt = 0
for i in range(n):
    if tree[i] != -10 and i not in tree:
        cnt +=1
# print(tree)
print(cnt)