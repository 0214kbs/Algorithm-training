import sys
input = sys.stdin.readline

S = input().rstrip()
q = int(input())

prefix_sum = [[0]*len(S) for _ in range(26)]

for i in range(len(S)):
    if i == 0:
        prefix_sum[ord(S[i])-97][i] +=1
    else:
        for j in range(26):
            prefix_sum[j][i] = prefix_sum[j][i-1]
        prefix_sum[ord(S[i])-97][i] +=1

for _ in range(q):
    a, l, r = input().split()
    if int(l) == 0:
        print(prefix_sum[ord(a)-97][int(r)])
    else:
        print(prefix_sum[ord(a)-97][int(r)]-prefix_sum[ord(a)-97][int(l)-1])

# print(prefix_sum[0])