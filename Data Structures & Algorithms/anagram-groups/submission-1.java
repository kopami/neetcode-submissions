class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        String key;
        for (int i = 0; i < strs.length; i++) {
            key = toFrequency(strs[i]);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

    public String toFrequency(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        return Arrays.toString(count);
    }
}
