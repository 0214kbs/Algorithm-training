import sys
input = sys.stdin.readline

n, m = map(int, input().split())
dots = list(map(int, input().split()))
dots.sort()

def find_dot(num,se):
    left, right = 0,n-1
    while left<=right:
        mid = (left+right)//2
        if num>dots[mid]:
            left = mid + 1
        elif num<dots[mid]:
            right = mid - 1
        else:
            return mid
    if se == 's':
        return left
    else:
        return right

for i in range(m):
    s,e = map(int, input().split())
    fd_s = find_dot(s,'s')
    fd_e = find_dot(e,'e')
    print(fd_e-fd_s+1)