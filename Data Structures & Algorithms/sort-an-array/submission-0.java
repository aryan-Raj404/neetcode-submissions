class Solution {
    public int[] sortArray(int[] nums) {

        return mergeHelper(nums,0,nums.length-1);         
        
    }

    public int[] mergeHelper(int[] nums,int startIdx,int endIdx){
        if(startIdx == endIdx){
            int[] arr = new int[1];
            arr[0] = nums[startIdx];
            return arr;
        }

        int mid = (startIdx+endIdx)/2;
        int[] leftArr = mergeHelper(nums,startIdx,mid);
        int[] rightArr = mergeHelper(nums,mid+1,endIdx);
        return merge2Arrays(leftArr,rightArr);
    }

    public int[] merge2Arrays(int[] n1,int[] n2){
        int i = 0;
        int j = 0;
        int k = 0;
        int[] result = new int[n1.length + n2.length];

        while(i < n1.length && j < n2.length){
            if(n1[i] > n2[j]){
                result[k] = n2[j++];
            }else{
                result[k] = n1[i++];
            }
            k++;
        }
        while(i < n1.length){
            result[k++] = n1[i++];
        }
        while(j < n2.length){
            result[k++] = n2[j++];
        }
        return result;
    }
}