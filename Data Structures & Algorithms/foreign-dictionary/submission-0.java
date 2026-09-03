class Solution {
    public String foreignDictionary(String[] words) {

        List<List<Character>> adj = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<Character>());
        }

        int[] indegree = new int[26];

        HashSet<Character> hs = new HashSet<>();

        // Add all characters
        for (String word : words) {
            for (char c : word.toCharArray()) {
                hs.add(c);
            }
        }

        // Build graph
        for (int i = 0; i < words.length - 1; i++) {

            int idx = 0;

            while (idx < words[i].length() &&
                   idx < words[i + 1].length()) {

                char a = words[i].charAt(idx);
                char b = words[i + 1].charAt(idx);

                if (a != b) {

                    // Avoid duplicate edge
                    if (!adj.get(a - 'a').contains(b)) {
                        adj.get(a - 'a').add(b);
                        indegree[b - 'a']++;
                    }

                    break;
                }

                idx++;
            }

            // Invalid case:
            // "abc" comes before "ab"
            if (idx == words[i + 1].length() &&
                words[i].length() > words[i + 1].length()) {
                return "";
            }
        }

        // Topological sort
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            if (hs.contains((char) ('a' + i)) && indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {

            int front = q.remove();

            sb.append((char) ('a' + front));

            for (char c : adj.get(front)) {

                indegree[c - 'a']--;

                if (indegree[c - 'a'] == 0) {
                    q.add(c - 'a');
                }
            }
        }

        // Cycle detected
        if (sb.length() != hs.size()) {
            return "";
        }

        return sb.toString();
    }
}