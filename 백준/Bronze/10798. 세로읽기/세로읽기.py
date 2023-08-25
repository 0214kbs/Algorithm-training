import sys
input = sys.stdin.readline
res =''
strlist = []
max_len = 0
for _ in range(5):
    a = list(input())[:-1]
    strlist.append(a)
    max_len = max(len(a),max_len)
    

for point_i in range(max_len):
    for list_i in range(5):
        if len(strlist[list_i]) > point_i:
            res += strlist[list_i][point_i]

print(res)

