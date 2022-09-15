import sys
input = sys.stdin.readline

n = int(input())

# 5 최대 개수
n_five = int(n/5)

res = 0
for i in range(n_five,-1,-1):
  check_n = n
  check_n -= 5*i
  if check_n %2 == 0:
    res = i+int(check_n/2)
    break
  
if res == 0:
  print("-1")
else:
  print(res)