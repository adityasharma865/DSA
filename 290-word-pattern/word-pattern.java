class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> reverseMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            // Check character -> word mapping
            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(word)) {
                    return false;
                }
            } else {
                map.put(ch, word);
            }

            // Check word -> character mapping
            if (reverseMap.containsKey(word)) {
                if (reverseMap.get(word) != ch) {
                    return false;
                }
            } else {
                reverseMap.put(word, ch);
            }
        }

        return true;
    }
}