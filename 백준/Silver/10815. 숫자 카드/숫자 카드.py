import sys
import bisect
input = sys.stdin.readline

N = int(input())
NList = list(map(int, input().split()))
NList.sort()
M = int(input())
MList = list(map(int, input().split()))

for m in MList:
    tmp = bisect.bisect_right(NList, m)
    tmp1 = bisect.bisect_left(NList, m)
    # print(tmp1, tmp)
    if tmp-tmp1>0:
        print("1", end=" ")
    else:
        print("0", end=" ")