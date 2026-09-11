class Solution {
public String minWindow(String s, String t) {
int[] freq = new int[128];

for (char c : t.toCharArray()) {  
        freq[c]++;  
    }  

    int left = 0;  
    int count = t.length();  
    int minLength = Integer.MAX_VALUE;  
    int start = 0;  

    for (int right = 0; right < s.length(); right++) {  
        char c = s.charAt(right);  

        if (freq[c] > 0) {  
            count--;  
        }  

        freq[c]--;  

        while (count == 0) {  
            if (right - left + 1 < minLength) {  
                minLength = right - left + 1;  
                start = left;  
            }  

            char leftChar = s.charAt(left);  
            freq[leftChar]++;  

            if (freq[leftChar] > 0) {  
                count++;  
            }  

            left++;  
        }  
    }  

    if (minLength == Integer.MAX_VALUE) {  
        return "";  
    }  

    return s.substring(start, start + minLength);  
}

}
