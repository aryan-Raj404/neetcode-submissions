
class Solution {
    List<Integer> l = new ArrayList<>();
    
    // Using a safe Unit Separator character that won't appear in normal text
    private static final String DELIMITER = "\u001f"; 

    public String encode(List<String> strs) {
        if(strs.size() == 0) return "";
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<strs.size(); i++){
            String s = strs.get(i);
            if(s.equals("")){
                l.add(i);
            }
            else{
                sb.append(s);
                sb.append(DELIMITER);
            }
        }
        if (sb.length() > 0 && sb.toString().endsWith(DELIMITER)) {
            sb.delete(sb.length() - DELIMITER.length(), sb.length());
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        if (str.isEmpty()) {
            List<String> list = new ArrayList<>();
            for (int i : l) {
                list.add("");
            }
            return list;
        }

        // Split by the exact delimiter. The -1 preserves trailing empty fields accurately.
        List<String> list = new ArrayList<>(Arrays.asList(str.split(DELIMITER, -1)));
        
        for (int i : l) {
            if (i <= list.size()) {
                list.add(i, "");
            } else {
                list.add(""); 
            }
        }
        return list;
    }
}
