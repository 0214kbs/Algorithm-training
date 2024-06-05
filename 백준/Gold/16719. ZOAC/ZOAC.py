def func(start,end):
    global now
    if start>end or start<0 or end>len(str_list):
        return

    cur_list = str_list[start:end+1]
    # print('func:',start,end,cur_list)
    nxt = cur_list[0]
    nxt_i = 0
    for ci in range(1,len(cur_list)):
        c = cur_list[ci]
        if c<nxt and not now[start+ci]:
            nxt = c
            nxt_i = ci
    # print(str_list[start+nxt_i], 'before:',start+nxt_i+1,end, 'after:',start,start+nxt_i-1)
    now[start+nxt_i] = True
    tmp = ''
    for i in range(len(now)):
        if now[i]:
            tmp += str_list[i]
    if len(tmp) > 0:
        print(tmp)
    if len(tmp) == len(now):
        return
    if start != end:
        func(start+nxt_i+1,end)
        func(start,start+nxt_i-1)



str_list = list(input().rstrip())
now = [False for _ in range(len(str_list))]
func(0,len(str_list)-1)