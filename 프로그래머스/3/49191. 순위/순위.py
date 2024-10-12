def solution(n, results):
    answer = 0
    graph = [[0]*n for _ in range(n)]
    for a, b in results:
        graph[a-1][b-1] = 1
        graph[b-1][a-1] =-1
        
    for k in range(n):
        for i in range(n):
            for j in range(n):
                if graph[i][k] == 1 and graph[k][j] == 1:
                    graph[i][j] = 1
                elif graph[i][k] == -1 and graph[k][j] == -1:
                    graph[i][j] = -1
    
    for i in range(n):
        tmp = 0
        for j in range(n):
            if graph[i][j] == 0:
                tmp += 1
        if tmp == 1:
            answer += 1
    return answer