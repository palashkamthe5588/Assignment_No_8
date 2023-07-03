
💡 **Question 6**

Given two strings s and p, return *an array of all the start indices of* p*'s anagrams in* s. You may return the answer in **any order**.

An **Anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

**Example 1:**

**Input:** s = "cbaebabacd", p = "abc"

**Output:** [0,6]

**Explanation:**

The substring with start index = 0 is "cba", which is an anagram of "abc".

The substring with start index = 6 is "bac", which is an anagram of "abc".

soln ://Time complexity:O(n);
     //space complexity:O(1);

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
          List<Integer> result = new ArrayList<>();
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        // create frequency map of p
        for (int i = 0; i < p.length(); i++) {
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
        }

        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
            right++;

            // check if windowMap and pMap are equal
            if (pMap.equals(windowMap)) {
                result.add(left);
            }

            // if window size > p size, move left pointer
            if (right - left == p.length()) {
                char leftChar = s.charAt(left);
                if (windowMap.containsKey(leftChar)) {
                    windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                    if (windowMap.get(leftChar) == 0) {
                        windowMap.remove(leftChar);
                    }
                }
                left++;
            }
        }

        return result;
    }
}