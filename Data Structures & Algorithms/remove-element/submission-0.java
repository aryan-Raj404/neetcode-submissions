class Solution {
    public int removeElement(int[] nums, int val) {
        int occur = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == val) occur++;
        }
        int l =0;
        int r = nums.length-1;
        while(l < r){
            if(nums[l] != val){
                if(nums[r] == val) r--;
                l++;
            }
            else{
                if(nums[r] != val){
                    nums[l] = nums[r];
                    l++;
                }
                r--;
            }
        }
        return nums.length - occur;
    }
}