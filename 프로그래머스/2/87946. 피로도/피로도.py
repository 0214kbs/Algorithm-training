g_dungeons =[]
answer = 0
def check(curi,curk, visited, cnt):
    global answer
    if curk <= 0:
        return
    
    need, waste = g_dungeons[curi][0], g_dungeons[curi][1]
    if need <= curk:
        answer = max(cnt, answer)
        for vi in range(len(visited)):
            if not visited[vi]:
                 # 탐험 
                visited[vi] = True
                check(vi, curk-waste, visited, cnt+1)
                visited[vi] = False

def solution(k, dungeons):
    global g_dungeons
    g_dungeons = dungeons
    
    for i in range(len(dungeons)):
        visited = [False for _ in range(len(dungeons))]
        visited[i] = True
        check(i,k, visited, 1)
        visited[i] = False
    return answer