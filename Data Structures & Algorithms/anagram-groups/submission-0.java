class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<Integer>> hm = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String s = strs[i];
            char arr[] = s.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            if(hm.containsKey(sorted)){
                List<Integer> l = hm.get(sorted);
                l.add(i);
                hm.put(sorted,l);
            }else{
                List<Integer> l = new ArrayList<>();
                l.add(i);
                hm.put(sorted,l);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(String s : hm.keySet()){
            List<Integer> l = hm.get(s);
            List<String> tl = new ArrayList<>();
            for(int i : l){
                tl.add(strs[i]);
            }
            ans.add(tl);
        }
        return ans;
    }
}
