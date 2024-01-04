T = int(input())

res = True
def check(str,a,b,tmp):
    while a<=b:
        if str[a] == str[b]:
            a+=1
            b-=1
        else:
            if tmp == 0:
                left = check(str, a+1, b, tmp+1)
                right = check(str, a,b-1,tmp+1)
                return min(left,right)
            else:
                return 2
    return tmp


for t in range(T):
    res = True
    str = input()
    print(check(str,0, len(str)-1,0))