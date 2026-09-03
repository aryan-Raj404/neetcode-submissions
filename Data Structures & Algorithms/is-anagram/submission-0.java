class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] a = new int[26];
        for(int i=0;i<s.length();i++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            a[sc-97]++;
            a[tc-97]--;
        }
        for(int i : a){
            if(i!=0) return false;
        }
        return true;
    }
}
