import sys

input = sys.stdin.readline

class Node(object):
    def __init__(self, key, data = None):
        self.key = key #단어의 글자 하나를 담는 곳
        self.data = data #마지막 글자의 경우, 단어전체를 data필드에 저장, 아닌경우는 null
        self.children = {}


class Trie:
    def __init__(self):
        self.head = Node(None)  #key = None

    #trie에 문자열 삽입
    def insert(self, string):
        current_node = self.head #루트부터!

        for char in string:
            if char not in current_node.children: #알파벳이 자식에 존재하지 않으면
                current_node.children[char] = Node(char)
            current_node = current_node.children[char] #curr_node를 업데이트
        current_node.data = string #string의 마지막 글자 차례이면, 노드의 data필드에 string 문자열 전체 저장

    def printStructure(self, L, current_node):
        if L == 0:
            current_node = self.head

        for child in sorted(current_node.children.keys()):
            print("--"*L,child, sep="")
            self.printStructure(L+1, current_node.children[child])

N = int(input())
trie = Trie()
for _ in range(N):
    string = list(input().split())
    trie.insert(string[1:])
trie.printStructure(0,None)
