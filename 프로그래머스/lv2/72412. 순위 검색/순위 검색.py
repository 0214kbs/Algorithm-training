from itertools import combinations
from bisect import bisect_left

def make_case(info, info_dict):
    info_list = info.split(" ")
    score = int(info_list[-1])
    for i in range(5):
        for c in combinations(info_list[:-1],i): # 0개, 1개, 2개, 3개, 4개로 이뤄진 조합
            key = "".join(c)
            if key in info_dict:
                info_dict[key].append(score)
            else:
                info_dict[key] = [score]

def solution(info, query):
    info_dict = dict()
    for i in info:
        make_case(i, info_dict)

    # 각 value 값 정렬
    for k in info_dict.keys():
        info_dict[k].sort()

    answer =[]
    for q in query:
        tmp_list = q.split(" ") 
        tmp_list = [i for i in tmp_list if i not in {'and','-'}]
        q_score = int(tmp_list[-1])
        key = "".join(tmp_list[:-1])
        if key in info_dict:
            ans = len(info_dict[key]) - bisect_left(info_dict[key],q_score)
            answer.append(ans)
        else:
            answer.append(0)
    return answer
