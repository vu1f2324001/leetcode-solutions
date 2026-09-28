class Solution {
public boolean isScramble(String s1, String s2) {
HashMap<String, Boolean> memo = new HashMap<>();
return solve(s1, s2, memo);
}

private boolean solve(String s1, String s2, HashMap<String, Boolean> memo) {  
    if (s1.equals(s2)) {  
        return true;  
    }  

    String key = s1 + "#" + s2;  

    if (memo.containsKey(key)) {  
        return memo.get(key);  
    }  

    int n = s1.length();  

    int[] count = new int[26];  

    for (int i = 0; i < n; i++) {  
        count[s1.charAt(i) - 'a']++;  
        count[s2.charAt(i) - 'a']--;  
    }  

    for (int value : count) {  
        if (value != 0) {  
            memo.put(key, false);  
            return false;  
        }  
    }  

    for (int i = 1; i < n; i++) {  

        String s1Left = s1.substring(0, i);  
        String s1Right = s1.substring(i);  

        String s2Left = s2.substring(0, i);  
        String s2Right = s2.substring(i);  

        if (solve(s1Left, s2Left, memo) &&  
            solve(s1Right, s2Right, memo)) {  
            memo.put(key, true);  
            return true;  
        }  

        String s2RightPart = s2.substring(n - i);  
        String s2LeftPart = s2.substring(0, n - i);  

        if (solve(s1Left, s2RightPart, memo) &&  
            solve(s1Right, s2LeftPart, memo)) {  
            memo.put(key, true);  
            return true;  
        }  
    }  

    memo.put(key, false);  
    return false;  
}

}
