from collections import deque
def solution(bridge_length, weight, truck_weights):
    time = bridge_length
    bridge = deque([0]*bridge_length)
    all_w = 0
    while truck_weights:
        cur_w = truck_weights[0]
        all_w -= bridge[0] 
        bridge.popleft()
        bridge.append(0)

        if bridge[-1] == 0 and (cur_w+all_w)<=weight:
            bridge[-1] = cur_w
            truck_weights = truck_weights[1:]
            all_w += cur_w
        else:
            bridge[-1] = 0
        time+=1

    return time