# (x,y) 5개의 좌표가 있을때,
# x 오름차순, x가 같을때 y 오름차순
a = [list(map(int, input().split())) for _ in range(5)]
a.sort(key=lambda x: x[0])

print(a)