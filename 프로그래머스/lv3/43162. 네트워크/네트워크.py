def solution(n, computers):
    answer = 0
    visited = [0]*n
    
    def dfs(i):
        visited[i] = 1
        for next in range(n):
            if visited[next]==0 and computers[i][next]: 
                dfs(next)
        
    for i in range(n):
        if not visited[i]:
            dfs(i)
            answer+=1
            
    
    return answer