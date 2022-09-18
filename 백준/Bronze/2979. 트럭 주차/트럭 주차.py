import sys

input = sys.stdin.readline

a,b,c = map(int, input().split())

s,e = map(int,input().split())
s1,e1 = map(int,input().split())
s2,e2 = map(int,input().split())

max_t = max(e,e1,e2)

time = [0 for i in range(max_t+1)]

for i in range(s,e+1):
  time[i] +=1

for i in range(s1,e1+1):
  time[i] +=1

for i in range(s2,e2+1):
  time[i] +=1

res = 0
check_time = []
for i in range(max_t+1):
  if time[i-1]<time[i]:
    check_time.append(time[i-1])
  else:
    check_time.append(time[i])

for t in check_time:
  if t ==1:
    res+= t*a
  elif t ==2:
    res+= t*b
  elif t ==3 :
    res+= t*c
print(res)