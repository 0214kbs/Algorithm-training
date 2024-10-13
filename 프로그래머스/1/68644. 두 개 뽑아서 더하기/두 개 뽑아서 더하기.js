function solution(numbers) {
    var answer = new Set();
    for(let i=0;i<numbers.length-1;i++){
        for(let j=i+1;j<numbers.length;j++){
            let sumv = numbers[i]+numbers[j];
            answer.add(sumv);
        }
    }
    answer = [...answer];
    // console.log(answer);
    answer.sort((a,b)=>a-b);
    // console.log(answer);
    return answer;
}