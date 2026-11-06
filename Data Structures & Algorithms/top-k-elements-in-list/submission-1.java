class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // use bucket sort to group which nums have the same frequency 
        List<Integer>[] buckets = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        // calculate frequency
        for (int num : nums) {
            frequencyMap.merge(num, 1, Integer::sum);
        }

        // bucket sort asc using array index as key
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();
            buckets[frequency].add(num);
        }

        // Loop backwards to get the top K results
        int[] result = new int[k];
        int index = 0;
        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
            for (int n : buckets[i]) {
                result[index++] = n;
                if (index == k) {
                    return result;
                }
            }
            
        }
        return result;
    }
}
