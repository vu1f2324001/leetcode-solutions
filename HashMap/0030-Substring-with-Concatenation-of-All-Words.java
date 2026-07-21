import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> ans = new ArrayList<>();

        if (s == null || s.length() == 0 || words.length == 0)
            return ans;

        int wordLen = words[0].length();
        int totalWords = words.length;

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {

            int left = i;
            int count = 0;

            HashMap<String, Integer> seen = new HashMap<>();

            for (int right = i; right + wordLen <= s.length(); right += wordLen) {

                String word = s.substring(right, right + wordLen);

                if (map.containsKey(word)) {

                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    count++;

                    while (seen.get(word) > map.get(word)) {

                        String leftWord = s.substring(left, left + wordLen);

                        seen.put(leftWord, seen.get(leftWord) - 1);

                        left += wordLen;
                        count--;
                    }

                    if (count == totalWords) {

                        ans.add(left);

                        String leftWord = s.substring(left, left + wordLen);

                        seen.put(leftWord, seen.get(leftWord) - 1);

                        left += wordLen;
                        count--;
                    }

                } else {

                    seen.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }

        return ans;
    }
}
