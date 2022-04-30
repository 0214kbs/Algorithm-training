# DFS - 깊이 우선 탐색
# -> 스택을 이용. 파이썬에서 리스트는 스택으로 구현되어 있음

# 1과 2,3,8연결 2와 1,7 연결되어있음..
graph = [
    [],
    [2, 3, 8],
    [1, 7],
    [1, 4, 5],
    [3, 5],
    [3, 4],
    [7],
    [2, 6, 8],
    [1, 7]
]

# 방문노드
visited = [False] * len(graph)


def dfs(graph, c, visited):
    # c : 현재 위치
    visited[c] = True
    print(c, end=' ')

    for i in graph[c]:
        if not visited[i]:
            dfs(graph, i, visited)



# 0번 노드가 없으니 1번 노드부터 탐색
dfs(graph, 1, visited)
