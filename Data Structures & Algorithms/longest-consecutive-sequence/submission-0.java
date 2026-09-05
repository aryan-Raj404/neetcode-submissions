class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        HashSet<Integer> hs = new HashSet<>();

        for(int num : nums){
            hs.add(num);
        }

        int lcs = 1;

        for(int num : hs){

            if(!hs.contains(num - 1)){

                int current = num;
                int streak = 1;

                while(hs.contains(current + 1)){
                    current++;
                    streak++;
                }

                lcs = Math.max(lcs, streak);
            }
        }

        return lcs;
    }
}
