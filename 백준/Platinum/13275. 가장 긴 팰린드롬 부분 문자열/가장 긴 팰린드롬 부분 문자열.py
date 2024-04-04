import sys
input = sys.stdin.readline

def manacher(S,A):
    n = len(S)
    p, r = 0,0

    for i in range(n):
        if i<=r:
            j = 2*p -i
            A[i] = min(r-i,A[j])
        else:
            A[i] = 0

        right = i+A[i]+1
        left = i-A[i]-1
        while 0<=right<n and 0<=left<n and S[right] == S[left]:
            A[i]+=1
            right += 1
            left -=1

        if i+A[i]>r:
            p = i
            r = p+A[p]
    return max(A)

s = input().rstrip()
A = [0]*(2*len(s)+1)
str = ['#']
for i in range(len(s)):
    str.append(s[i])
    str.append('#')
res = manacher(str,A)
print(res)