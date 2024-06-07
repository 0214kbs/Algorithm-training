import sys
input = sys.stdin.readline
INF = int(1e9)
TC = int(input())
def bf():
    for i in range(N):
        for j in range(len(edges)):
            cur,nxt,cost = edges[j]
            if values[nxt] > values[cur]+cost:
                values[nxt] =values[cur]+cost
                if i == N-1:
                    return True
    return False

for _ in range(TC):
    N,M,W = map(int, input().split())

    edges = []
    values = [INF for _ in range(N+1)]
    # 도로 정보
    for _ in range(M):
        S,E,T = map(int, input().split())
        edges.append((S,E,T))
        edges.append((E,S,T))
    # 웜홀 정보
    for _ in range(W):
        S,E,T = map(int, input().split())
        edges.append((S,E,-T))

    if bf():
        print("YES")
    else:
        print("NO")