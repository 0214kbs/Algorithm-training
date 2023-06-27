import sys


class Node:
    def __init__(self, data, left, right):
        self.data = data
        self.left = left
        self.right = right


tree = {}
n = int(input())

for _ in range(n):
    data, left, right = sys.stdin.readline().split()
    tree[data] = Node(data, left, right)


def PreOrder(node):
    print(node.data, end="")
    if node.left != ".":
        PreOrder(tree[node.left])
    if node.right != ".":
        PreOrder(tree[node.right])


def InOrder(node):
    if node.left != ".":
        InOrder(tree[node.left])
    print(node.data, end="")
    if node.right != ".":
        InOrder((tree[node.right]))


def PostOrder(node):
    if node.left != ".":
        PostOrder(tree[node.left])
    if node.right != ".":
        PostOrder(tree[node.right])
    print(node.data, end="")


PreOrder(tree['A'])
print(" ")
InOrder(tree['A'])
print(" ")
PostOrder(tree['A'])
