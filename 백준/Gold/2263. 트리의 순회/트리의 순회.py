import sys

sys.setrecursionlimit(10 ** 6)
n = int(input())
inorder = list(map(int, input().split()))
postorder = list(map(int, input().split()))

idx = [0] * (n+1)
for i in range(n):
    idx[inorder[i]] = i
    
    
def preOrder(in_start, in_end, post_start, post_end):
    if in_start > in_end or post_start > post_end:
        return

    root = postorder[post_end]
    print(root, end=" ")

    In_Idx = idx[root]
    left = In_Idx - in_start 

    preOrder(in_start, In_Idx - 1, post_start, (post_start + left) - 1)
    preOrder(In_Idx + 1, in_end, post_start + left, post_end - 1)
preOrder(0, n - 1, 0, n - 1)