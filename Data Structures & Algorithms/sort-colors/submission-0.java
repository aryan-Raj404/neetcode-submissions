class Solution {
    public void sortColors(int[] nums) {
        int a = 0;
        int b = 0;
        int c = 0;
        int i =0;
        while(i<nums.length){
            if(nums[i] == 0){
                a++;
            }
            else if(nums[i] == 1){
                b++;
            }
            else{
                c++;
            }
            i++;
        }
        i=0;
        while(a!=0){
            nums[i++] = 0;
            a--;
        }
        while(b!=0){
            nums[i++] = 1;
            b--;
        }
        while(c!=0){
            nums[i++] = 2;
            c--;
        }
    }
}