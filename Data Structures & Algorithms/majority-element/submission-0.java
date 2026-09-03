class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int major = (int)Math.floor(nums.length/2);
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                hm.put(nums[i],hm.get(nums[i])+1);
                if(hm.get(nums[i]) > major){
                    return nums[i];
                }
            }else{
                hm.put(nums[i],1);
            }
        }
        for(Integer key : hm.keySet()){
            if(hm.get(key) > major){
                return key;
            }
        }
        return -1;
    }
}