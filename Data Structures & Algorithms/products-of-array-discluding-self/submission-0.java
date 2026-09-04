class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] l = new int[nums.length];
        int[] r = new int[nums.length];
        l[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            l[i] = nums[i] * l[i-1];
        }
        r[nums.length-1] = nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            r[i] = nums[i] * r[i+1];
        }
        for(int i=0;i<nums.length;i++){
            int left = i>0 ? l[i-1] : 1;
            int right = i<nums.length-1 ? r[i+1] : 1;
            nums[i] = left*right;
        }
        return nums;
    }
}  
