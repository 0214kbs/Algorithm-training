import sys
input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))
tmp = []
for n in nums:
    strn = str(n)
    length = len(strn)
    while len(strn)<10:
        strn += strn[len(strn)-length]
    tmp.append(([*list(strn)], str(n)))
    # print(tmp[-1])
tmp.sort(reverse=True)

res = ""
for t in tmp:
    res += t[-1]
if int(res) ==0:
    print(0)
else:
    print(int(res))