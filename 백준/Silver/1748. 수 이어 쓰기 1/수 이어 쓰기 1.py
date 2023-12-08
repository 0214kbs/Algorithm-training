n = input()
res = 0
for i in range(1,len(n)):
    res += 9*10**(i-1)*i
res +=(int(n)-10**(len(n)-1)+1)*len(n)
print(res)