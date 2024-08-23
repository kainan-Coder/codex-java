package com.uaian.algorithms.leecode;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start  = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                max = Math.max(max, i - start);
                start = map.get(s.charAt(i))  >= start ? map.get(s.charAt(i)) + 1: start;
            }
            map.put(s.charAt(i), i);
        }
        max = Math.max(max, s.length() - start);
        return max;
    }
}
