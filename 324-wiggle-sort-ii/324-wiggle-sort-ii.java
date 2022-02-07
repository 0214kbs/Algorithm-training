class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] answer = new int[nums.length];
        int len = nums.length;
        
        if (nums.length %2 != 0)
            len = nums.length+1;
        
        for(int i=0;i< len/2; i++){
            answer[i*2] = nums[len/2-i-1];
        }
        
        for(int i=0; i< nums.length/2; i++){
            answer[i*2+1] = nums[nums.length-i-1];
        }

        for(int i=0;i<nums.length; i++){
            nums[i] = answer[i];
        }
    }
}