n = int(input())
chu_list = list(map(int, input().split()))
m = int(input())
ball_list = list(map(int, input().split()))

max_V = sum(chu_list)
dp = [[False]*(max_V+1) for _ in range(len(chu_list)+1)]
dp[0][0] = True
for ci in range(len(chu_list)):
    c = chu_list[ci]
    for i in range(max_V+1):
        if dp[ci][i]:
            if i+c<=max_V:
                dp[ci+1][i+c] = True
            if abs(i-c)<=max_V:
                dp[ci+1][abs(i-c)] = True
            dp[ci+1][i]= True
# print(dp)
for ball in ball_list:
    if ball>max_V:
        print('N',end=" ")
        continue
    if dp[-1][ball]:
        print('Y',end=" ")
    else:
        print('N',end=" ")