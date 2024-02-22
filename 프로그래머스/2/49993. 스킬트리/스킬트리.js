function solution(skill, skill_trees) {
    var answer = 0;
    
    for(let i=0;i<skill_trees.length;i++){
        tmp = []
        flag = true 
        for(let j=0;j<skill_trees[i].length;j++){
            for(let k=0;k<skill.length;k++){
                if(skill_trees[i].charAt(j) === skill.charAt(k)){
                    tmp.push(k)
                }
            }
        }
        // console.log(tmp)
        for(let t=0;t<tmp.length;t++){
            if (tmp[t] != t){
                flag = false;
                break;
            }
        }
        if(flag === true) answer += 1
    }
    return answer;
}