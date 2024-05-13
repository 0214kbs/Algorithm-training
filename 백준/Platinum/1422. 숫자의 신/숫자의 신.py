import sys
input = sys.stdin.readline

N,K = map(int, input().split())
nums = [int(input()) for _ in range(N)]

tmp = []
tmp2 = []
for i in range(N):
    n = nums[i]
    strn = str(n)
    length = len(strn)
    while len(strn)<10:
        strn += strn[len(strn)-length]
    tmp.append(([*list(strn)], str(n)))
    tmp2.append((length,[*list(strn)], str(n)))
    # print(tmp[-1])
tmp.sort(reverse=True)
tmp2.sort(reverse=True)

res = ""
add = ""

flag = False
for t in tmp:
    if not flag:
        if ''.join(tmp2[0][1])>=''.join(t[0]):
            flag = True
            for i in range(K - N):
                add += tmp2[0][-1]
            res+=add
    res += t[-1]


if int(res) ==0:
    print(0)
else:
    print(int(res))