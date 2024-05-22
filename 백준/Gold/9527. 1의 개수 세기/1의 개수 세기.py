def count(num):
    if len(num) < 4:
        return int(num, 2)

    new_num = num[:2] + num[3:]
    if num[2] == "0":
        return count(new_num)
    else:
        return count(new_num) + dp[len(num)-3] + int(new_num, 2) + 1


A, B = map(int, input().split())

dp = [0]

length = len(bin(B)) - 2

for i in range(1, length):
    val = dp[i-1] * 2 + 2**(i-1)
    dp.append(val)

print(count(bin(B)) - count(bin(A-1)))