import sys
input = sys.stdin.readline

n = int(input())
res = 0
for _ in range(n):
  c_list = []
  str = input()
  cnt = 0
  c_list.append(str[0])
  for i in range(1,len(str)-1):
    c = str[i]
    if c in c_list and c != c_list[-1]:
      cnt = 1
      break
    else:
      c_list.append(c)
  
  # print(cnt)
  # print(c_list)
  if cnt == 0:
    res +=1


print(res)