
💡 **Question 8**

Given two strings s and goal, return true *if you can swap two letters in* s *so the result is equal to* goal*, otherwise, return* false*.*

Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].

- For example, swapping at indices 0 and 2 in "abcd" results in "cbad".

**Example 1:**

**Input:** s = "ab", goal = "ba"

**Output:** true

**Explanation:** You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.

soln :  //time complexity :O(n);
        //space complexity ;O(1);
 
 class Solution {
    public boolean buddyStrings(String s, String goal) {
        
    if (s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            for (int val : count) {
                if (val > 1) {
                    return true;
                }
            }

            return false;
        }

        int firstIndex = -1;
        int secondIndex = -1;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (count == 0) {
                    firstIndex = i;
                } else if (count == 1) {
                    secondIndex = i;
                }

                count++;
            }

            if (count > 2) {
                return false;
            }
        }

        return count == 2 && s.charAt(firstIndex) == goal.charAt(secondIndex) && s.charAt(secondIndex) == goal.charAt(firstIndex);
    }
}