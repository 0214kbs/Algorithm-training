# BFS - 너비 우선 탐색
# -> 큐(FIFO)를 이용. collections의 deque 이용!
from collections import deque
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

visited = [False] * len(graph)


def bfs(graph, start, visited):

    # 시작 노드를 큐에다가 먼저 삽입(삽입할 때 파이썬 리스트[]로 감싸주기)
    q = deque([start])
    # 시작 노드를 방문 처리
    visited[start] = True

    # 큐에서 노드를 pop하고 그 노드의 인접노드들을 탐색.
    # 단, 큐가 빌(False)때 까지
    while q:
        v = q.popleft()
        print(v, end=' ')
        for i in graph[v]:
            if not visited[i]:
                visited[i] = True
                q.append(i)


bfs(graph, 1, visited)