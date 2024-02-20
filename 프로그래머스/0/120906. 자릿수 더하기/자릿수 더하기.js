function solution(n) {
    var answer = 0;
    
    var str_n = n.toString();
    
    for(let i=0 ; i< str_n.length ;i++){
        answer += parseInt(str_n[i], 10);
    }
    return answer;
}