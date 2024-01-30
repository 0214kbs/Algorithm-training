s = input()
res = []
if len(s)<10:
    N = len(s)
else:
    N = 9+(len(s)-9)//2
check = [False]*(N+1)
check[0] = True
# print(N)


def find(cur):
    global res
    if len(res) == N:
        print(*res)
        exit(0)
    if cur>=len(s):
        return

    if not check[int(s[cur])]:
        check[int(s[cur])] = True
        res.append(s[cur])
        find(cur+1)
        res.pop()
        check[int(s[cur])] = False

    tmp = s[cur:cur + 2]
    if int(tmp)<len(check) and not check[int(tmp)]:
        check[int(tmp)] = True
        res.append(tmp)
        find(cur+2)
        res.pop()
        check[int(tmp)] = False

find(0)