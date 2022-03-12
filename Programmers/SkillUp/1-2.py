def solution(id_list, report, k):
    answer = [0] * len(id_list)

    result = set(report)
    result = list(result)

    dict ={}
    for id in id_list:
        dict[id] = []

    for i in result:
        show = i.split(" ")
        dict[show[1]] += [show[0]]

    for key, value in dict.items():
        if len(value)>=k:
            for p in value:
                answer[id_list.index(p)] += 1
    return answer