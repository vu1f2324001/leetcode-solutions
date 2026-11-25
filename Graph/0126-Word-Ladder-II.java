class Solution {
public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
List<List<String>> result = new ArrayList<>();

Set<String> words = new HashSet<>(wordList);  

    if (!words.contains(endWord)) {  
        return result;  
    }  

    Map<String, List<String>> parents = new HashMap<>();  
    Map<String, Integer> distance = new HashMap<>();  

    Queue<String> queue = new LinkedList<>();  
    queue.offer(beginWord);  
    distance.put(beginWord, 0);  

    int shortest = Integer.MAX_VALUE;  

    while (!queue.isEmpty()) {  
        String word = queue.poll();  
        int currentDistance = distance.get(word);  

        if (currentDistance >= shortest) {  
            continue;  
        }  

        char[] chars = word.toCharArray();  

        for (int i = 0; i < chars.length; i++) {  
            char original = chars[i];  

            for (char c = 'a'; c <= 'z'; c++) {  
                if (c == original) {  
                    continue;  
                }  

                chars[i] = c;  
                String next = new String(chars);  

                if (words.contains(next)) {  
                    int nextDistance = currentDistance + 1;  

                    if (!distance.containsKey(next)) {  
                        distance.put(next, nextDistance);  
                        queue.offer(next);  
                        parents.put(next, new ArrayList<>());  
                    }  

                    if (distance.get(next) == nextDistance) {  
                        parents.get(next).add(word);  
                    }  

                    if (next.equals(endWord)) {  
                        shortest = nextDistance;  
                    }  
                }  
            }  

            chars[i] = original;  
        }  
    }  

    if (!distance.containsKey(endWord)) {  
        return result;  
    }  

    List<String> path = new ArrayList<>();  
    path.add(endWord);  

    dfs(endWord, beginWord, parents, path, result);  

    return result;  
}  

private void dfs(String word, String beginWord,  
                 Map<String, List<String>> parents,  
                 List<String> path,  
                 List<List<String>> result) {  

    if (word.equals(beginWord)) {  
        List<String> sequence = new ArrayList<>(path);  
        Collections.reverse(sequence);  
        result.add(sequence);  
        return;  
    }  

    if (!parents.containsKey(word)) {  
        return;  
    }  

    for (String parent : parents.get(word)) {  
        path.add(parent);  

        dfs(parent, beginWord, parents, path, result);  

        path.remove(path.size() - 1);  
    }  
}

}
