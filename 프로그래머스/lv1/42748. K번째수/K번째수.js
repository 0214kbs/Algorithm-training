function solution(array, commands) {
    var answer = [];
    
    commands.map((c)=>{
        const list = array.slice(c[0]-1,c[1]);
        list.sort((a,b)=>a-b);
        answer.push(list[c[2]-1]);
    })
    return answer;
}