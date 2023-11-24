def solution(n, k, cmd):
    dll = {i: [i - 1, i + 1] for i in range(n + 1)}
    deleted = []
    answer = ['O' for _ in range(1,n+1)]
    pointer = k+1
    
    for c in cmd:
        if c[0] == 'U':
            a,b = c.split(" ")
            for _ in range(int(b)):
                pointer = dll[pointer][0]
        elif c[0] == 'D':
            a,b, = c.split(" ")
            for _ in range(int(b)):
                pointer = dll[pointer][1]
        elif c[0] == 'C':
            prev, next = dll[pointer]
            deleted.append((pointer, prev,next))
            answer[pointer-1] = 'X'
            if next == n+1:
                pointer = prev
            else:
                pointer = next
            
            if prev == 0:
                dll[next][0] = 0
            elif next == n+1:
                dll[prev][1] = n+1
            else:
                dll[next][0] = prev 
                dll[prev][1] = next
            
        else:
            tmp, prev, next = deleted.pop()
            answer[tmp-1] = 'O'
            if prev == 0:
                dll[next][0] = tmp
            elif next == n+1:
                dll[prev][1] = tmp
            else:
                dll[next][0] = tmp
                dll[prev][1] = tmp

    return ''.join(answer)