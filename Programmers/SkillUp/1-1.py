def solution(array, commands):
    answer = []

    for c in commands:
        i, j, k = c[0], c[1], c[2]
        arr = array[i-1:j]
        arr.sort()
        answer.append(arr[k-1])


    return answer