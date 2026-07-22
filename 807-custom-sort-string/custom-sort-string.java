class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> hm= new HashMap<>();

        for (char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        StringBuilder ans = new StringBuilder();

        for(char c: order.toCharArray()){
           while (hm.getOrDefault(c, 0) > 0) {
                ans.append(c);
                hm.put(c, hm.get(c) - 1);
            }
        }

        for (char c : s.toCharArray()){
            while (hm.getOrDefault(c, 0) > 0) {
                ans.append(c);
                hm.put(c, hm.get(c) - 1);
            }
        }

        return ans.toString();
    }
}