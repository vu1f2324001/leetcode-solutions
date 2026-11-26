class Solution {
public int ladderLength(String beginWord, String endWord, List<String> wordList) {
Set<String> words = new HashSet<>(wordList);

if (!words.contains(endWord)) {  
        return 0;  
    }  

    Queue<String> queue = new LinkedList<>();  
    queue.offer(beginWord);  

    int count = 1;  

    while (!queue.isEmpty()) {  
        int size = queue.size();  

        for (int j = 0; j < size; j++) {  
            String word = queue.poll();  

            if (word.equals(endWord)) {  
                return count;  
            }  

            char[] chars = word.toCharArray();  

            for (int i = 0; i < chars.length; i++) {  
                char original = chars[i];  

                for (char c = 'a'; c <= 'z'; c++) {  
                    chars[i] = c;  
                    String next = new String(chars);  

                    if (words.contains(next)) {  
                        queue.offer(next);  
                        words.remove(next);  
                    }  
                }  

                chars[i] = original;  
            }  
        }  

        count++;  
    }  

    return 0;  
}

}
