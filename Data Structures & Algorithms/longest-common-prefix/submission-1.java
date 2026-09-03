class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while(j < strs[0].length() && j < strs[1].length()){
            if(strs[0].charAt(j) == strs[1].charAt(j)){
                sb.append(strs[0].charAt(j));
            }
            else break;
            j++;
        }
        for(int i=2;i<strs.length && sb.length() > 0;i++){
            int idx=0;
            while(idx < strs[i].length() && idx < sb.length()){
                if(strs[i].charAt(idx) != sb.charAt(idx)){
                    break;
                }
                idx++;
            }
            sb.delete(idx, sb.length());
        }
        return sb.toString();
    }
}