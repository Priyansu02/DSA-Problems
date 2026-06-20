class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 > n2) return false;

        // Frequency map for s1
        Map<Character, Integer> freq1 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            freq1.put(c, freq1.getOrDefault(c, 0) + 1);
        }

        // Frequency map for the first window in s2
        Map<Character, Integer> freq2 = new HashMap<>();
        for (int i = 0; i < n1; i++) {
            char c = s2.charAt(i);
            freq2.put(c, freq2.getOrDefault(c, 0) + 1);
        }

        // Check first window
        if (freq1.equals(freq2)) return true;

        // Slide the window
        for (int i = n1; i < n2; i++) {
            char addChar = s2.charAt(i);
            char removeChar = s2.charAt(i - n1);

            // Add new char
            freq2.put(addChar, freq2.getOrDefault(addChar, 0) + 1);

            // Remove old char
            freq2.put(removeChar, freq2.get(removeChar) - 1);
            if (freq2.get(removeChar) == 0) {
                freq2.remove(removeChar); // keep map clean
            }

            // Compare maps
            if (freq1.equals(freq2)) return true;
        }
        return false; 
    }
}