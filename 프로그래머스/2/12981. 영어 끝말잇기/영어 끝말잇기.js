function solution(n, words) {
    var answer = [0,0];

    var who = 2;
    var turn = 1;
    for(let i=1;i<words.length;i++){
        if(who>n){
            who = 1;
            turn += 1;
        }
        if(words.indexOf(words[i]) !== i) {
            answer =  [who, turn];
            break;
        }
        if(words[i-1].charAt(words[i-1].length-1) !== words[i].charAt(0)) {
            answer =  [who, turn];
            break;
        }
        who+=1
    }

    return answer;
}