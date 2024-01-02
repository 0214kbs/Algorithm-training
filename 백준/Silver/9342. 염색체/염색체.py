import re
p = re.compile('^[A-F]?A+F+C+[A-F]?$')

T = int(input())

for _ in range(T):
    str = input()
    if p.match(str) == None:
        print('Good')
    else:
        print('Infected!')