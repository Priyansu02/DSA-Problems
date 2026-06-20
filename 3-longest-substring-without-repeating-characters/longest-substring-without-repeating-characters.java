class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set= new HashSet<>();
        int i=0,j=0,maxlength=0;

        while(i < s.length()){
           char ch=s.charAt(i);

            while(set.contains(ch)){
                set.remove(s.charAt(j));
                j++;

            }

            set.add(ch);
            maxlength=Math.max(maxlength, i-j+1);
            i++;
        }

        return maxlength;
    }
}