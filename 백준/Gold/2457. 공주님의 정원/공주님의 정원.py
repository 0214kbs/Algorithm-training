import sys
input = sys.stdin.readline

N = int(input())
flowers = []

for i in range(N):
    sm,sd, em,ed = map(int, input().split())
    # 편의를 위해 날짜 형식 바꾸기 - 월 *100
    flowers.append([sm*100+sd,em*100+ed])

flowers.sort()

cnt = 0 # 선택한 꽃 개수
end = 0 # 제일 늦게 지는 꽃을 비교
target = 301 # # 마지막 꽃이 지는 날

while flowers:
    if target>1130 or target<flowers[0][0]:
        # 마지막 꽃이 지는 날이 11/30 이후->성공
        # 제일 빨리 피는 꽃보다 작으면 -> 실패
        break

    for _ in range(len(flowers)):
        if target >= flowers[0][0]:
            if end<=flowers[0][1]:
                end = flowers[0][1]
            flowers.remove(flowers[0])
    target = end
    cnt += 1
if target < 1201:
    print(0)
else:
    print(cnt)