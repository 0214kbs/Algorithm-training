n= int(input())

while True:
    if n==1:
        break
    for i in range(2,n+1):
        if n%i == 0:
            n = n//i
            print(i)
            break