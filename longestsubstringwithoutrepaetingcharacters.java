import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int right = 0;
        int maxLength = 0;

        while (right < s.length()) {

            // If character is not present
            if (!set.contains(s.charAt(right))) {

                set.add(s.charAt(right));
                right++;

                maxLength = Math.max(maxLength, right - left);
            }
            else {
                // Remove characters until duplicate is removed
                set.remove(s.charAt(left));
                left++;
            }
        }

        return maxLength;
    }
}
