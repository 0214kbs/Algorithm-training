import sys
sys.setrecursionlimit(10 ** 8)

test_sum =[]

def sum_coin(sum,current_day):
    if current_day >= n:
        test_sum.append(sum)
        return

    next1 = current_day + table[current_day][0]
    next2 = current_day + 1

    #x
    if next2 <= n:
        sum_coin(sum, next2)
    # o
    if next1<=n:
        sum += table[current_day][1]
        sum_coin(sum, next1)





input = sys.stdin.readline
table = []
n = int(input())
for _ in range(n):
    table.append(list(map(int, input().split())))
# print(table)

sum_coin(0, 0)
test_sum.sort(reverse = True)
print(test_sum[0])