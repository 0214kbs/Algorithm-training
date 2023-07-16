function solution(nums) {
  const set = new Set(nums);

  var answer = set.size >= nums.length / 2 ? nums.length / 2 : set.size;
  return answer;
}