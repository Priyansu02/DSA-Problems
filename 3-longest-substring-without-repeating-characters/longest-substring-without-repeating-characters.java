class Solution {
    public int lengthOfLongestSubstring(String s) {
         Set<Character>set=new HashSet<>();
        int maxLength=0;
        int i=0;
        int j=0;
        while(i<s.length()){
            char c=s.charAt(i);

            while(set.contains(c)){
                set.remove(s.charAt(j));
                j++;
            }
            set.add(c);
            maxLength = Math.max(maxLength, i - j + 1);
            i++;


        }
        return maxLength;
    }
}