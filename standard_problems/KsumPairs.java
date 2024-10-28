class Result {
  static int getPairsCount(int arr[], int n, int k) {

        Map<Integer, Integer> freq = new HashMap<>();
        int cnt = 0;
        
        for (int num : arr) {
            int complement = k - num;
            if (freq.containsKey(complement)) {
                cnt += freq.get(complement);
            }
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        return cnt;
   }
}