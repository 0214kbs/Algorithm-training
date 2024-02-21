function solution(d, budget) {
    var answer = 0;
    d.sort((a, b) => a - b);
    
    let cnt = 0
    for(let i=0;i<d.length;i++){
        answer += 1;
        cnt += d[i]
        
        if(cnt > budget) {
            answer --;
            break;
        }
        
        
    }
    return answer;
}