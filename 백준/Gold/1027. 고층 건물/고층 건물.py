N = int(input())

building = list(map(int, input().split()))
res = 0

for i in range(N):
    temp = N - 1

    cur = building[i]
    for j in range(i + 1, N):  # i+1 ~ 끝 빌딩
        comp = building[j]
        for k in range(i + 1, j): # i와 비교대상j 사이에 건물 비교
            can_comp = building[k] # comp 볼 수 있는지 확인하는 빌딩
            if can_comp - cur >= (((comp - cur) / (j - i)) * (k - i)):
                temp -= 1
                break
    for j in range(0, i): # 처음 부터 ~ i-1 빌딩
        comp = building[j]
        for k in range(j + 1, i):
            can_comp = building[k]  # comp 볼 수 있는지 확인하는 빌딩
            if can_comp - comp >= (((cur - comp) / (i - j)) * (k - j)):
                temp -= 1
                break
    # print(temp, end=" ")
    res = max(temp, res)
print(res)