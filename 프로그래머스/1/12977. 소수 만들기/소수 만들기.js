function isPrime(x){
    if(x==0) return false;
    for(let i=2;i<=parseInt(Math.sqrt(x)+1,10);i++){
        if(x%i === 0) return false;
    }
    return true;
}


function solution(nums) {
    var answer = 0;
    
    for(let i=0;i<nums.length-2;i++){
        for(let j=i+1;j<nums.length-1;j++){
            for(let k=j+1;k<nums.length;k++){
                var tmp = nums[i]+nums[j]+nums[k];
                answer += isPrime(tmp) ? 1 : 0
            }
        }
    }    
    
    return answer;
}