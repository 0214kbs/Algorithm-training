name = input().rstrip()

graph = {}
for s in name:
    if s in graph:
        graph[s] +=1
    else:
        graph[s] = 1

str_list = sorted(graph.keys())
odd = 0
odd_alpha = ''
res = ''
for s in str_list:
    if graph[s] %2 != 0:
        odd+=1
        odd_alpha += s
    for _ in range(graph[s]//2):
        res += s

if odd >1:
    print("I'm Sorry Hansoo")
elif odd == 0:
    print(res+res[::-1])
else:
    print(res+odd_alpha+res[::-1])