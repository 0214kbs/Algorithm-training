import sys
input = sys.stdin.readline

a_dict ={}
N = int(input())
words = [input().rstrip() for _ in range(N)]

for word in words:
    for wi in range(len(word)):
        x = 10**(len(word)-wi-1)
        if word[wi] in a_dict:
            a_dict[word[wi]] += x
        else:
            a_dict[word[wi]] = x

sorted_a = sorted(a_dict.values(),reverse=True)
res = 0
last_use = 9
for v in sorted_a:
    res += v*last_use
    last_use-=1
print(res)