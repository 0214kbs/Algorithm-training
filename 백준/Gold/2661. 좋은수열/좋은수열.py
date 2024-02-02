N = int(input())


cnt = 0
tmp = ''

def check(str):
    for i in range(1,len(str)//2+1):
        if str[-i*2:-i] == str[-i:]:
            return False
    return True

def make(num):
    if len(num) == N:
        print(num)
        exit(0)

    for a in '123':
        if check(num+a):
            make(num+a)

make('1')