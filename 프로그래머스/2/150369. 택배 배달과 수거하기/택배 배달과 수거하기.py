def solution(cap, n, deliveries, pickups):
    
    # 먼곳 부터 
    delivery = 0
    pickup = 0
    
    dist = 0
    # maxi = n-1
    for i in range(n-1, -1, -1):
        delivery += deliveries[i]
        pickup += pickups[i]
        
        while delivery>0 or pickup >0:
            delivery -= cap
            pickup -= cap
            dist += (i+1)*2
        # if delivery>=cap or pickup >= cap:
        #     delivery -= cap
        #     pickup -= cap
        #     dist += (maxi+1)*2
        #     maxi = i-1
        #     continue
    # if delivery >0 or pickup >0:
    #     dist += (maxi+1)*2
   
    return dist