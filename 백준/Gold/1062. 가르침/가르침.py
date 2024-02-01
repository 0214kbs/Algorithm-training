import sys
from itertools import combinations
input = sys.stdin.readline

N,K = map(int, input().split())
teach = {'a','n','t','i','c'}
remain = set(chr(i) for i in range(97,123))- teach
slist = [input().rstrip()[4:-4] for _ in range(N)]

def count(learned):
    cnt = 0
    for word in slist:
        canRead = True
        for w in word:
            if not learned[ord(w)-ord('a')]:
                canRead = False
                break
        if canRead:
            cnt+=1
    return cnt


if K>=5:
    res = 0
    learnlist = [False] * 26
    for t in teach:
        learnlist[ord(t) - ord('a')] = True

    for learn in list(combinations(remain,K-5)):
        for l in learn:
            learnlist[ord(l)-ord('a')] = True
        cnt = count(learnlist)

        res = max(res,cnt)
        for l in learn:
            learnlist[ord(l) - ord('a')] = False
    print(res)
else:
    print(0)