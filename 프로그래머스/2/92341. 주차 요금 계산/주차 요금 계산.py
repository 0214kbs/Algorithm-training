import math

def calc(fees, total):
    if total> fees[0]:
        return fees[1]+math.ceil((total-fees[0])/fees[2])*fees[3]
    else:
        return fees[1]
    
def solution(fees, records):
    answer = []
    cartime = {}
    
    INs ={}
    
    for record in records:
        time, carnum, state = record.split(" ")
        if state == "IN":
            INs[carnum] = time
        else:
            outhh, outmm = time.split(":")
            inhh, inmm =  INs[carnum].split(":")
            
            hh = int(outhh) - int(inhh)
            mm = int(outmm) - int(inmm)
            if cartime.get(carnum):
                cartime[carnum] += hh*60+mm
            else:
                cartime[carnum] = hh*60+mm
            del INs[carnum]
            # print(carnum, INs[carnum])
    
    if INs:
        incars = INs.keys()
        for car in incars:
            inhh, inmm =  INs[car].split(":")
            
            hh = 23 - int(inhh)
            mm = 59 - int(inmm)
            if cartime.get(car):
                cartime[car] += hh*60+mm
            else:
                cartime[car] = hh*60+mm
    
    # 차량별로 계산..(오름차순)
    sorted_cars = sorted(cartime.keys())
    for car in sorted_cars:
        answer.append(calc(fees, cartime[car]))
    
    
        
    return answer