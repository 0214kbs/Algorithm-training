import sys

input = sys.stdin.readline

str = input()

check = []
res = 1
length = len(str)-1 # level, 5
idx = int(length/2)
if length == 1:
  print("1")
else:
  for i in range(idx):
    check.append(str[i])
#  print(check)
  if length %2 != 0:
    idx +=1
  for i in range(idx,length):
    if check.pop() == str[i]:
      pass
    else:
      res = 0
      print("0")
      break
  if res == 1:
    print("1")