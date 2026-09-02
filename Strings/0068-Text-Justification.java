class Solution {
public List<String> fullJustify(String[] words, int maxWidth) {
List<String> result = new ArrayList<>();

int i = 0;  

    while (i < words.length) {  
        int j = i;  
        int letters = 0;  

        while (j < words.length &&  
               letters + words[j].length() + (j - i) <= maxWidth) {  
            letters += words[j].length();  
            j++;  
        }  

        int spaces = maxWidth - letters;  
        int gaps = j - i - 1;  

        StringBuilder line = new StringBuilder();  

        if (j == words.length || gaps == 0) {  
            for (int k = i; k < j; k++) {  
                if (k > i) {  
                    line.append(" ");  
                }  
                line.append(words[k]);  
            }  

            while (line.length() < maxWidth) {  
                line.append(" ");  
            }  
        } else {  
            int eachSpace = spaces / gaps;  
            int extraSpace = spaces % gaps;  

            for (int k = i; k < j; k++) {  
                line.append(words[k]);  

                if (k < j - 1) {  
                    int count = eachSpace;  

                    if (k - i < extraSpace) {  
                        count++;  
                    }  

                    for (int x = 0; x < count; x++) {  
                        line.append(" ");  
                    }  
                }  
            }  
        }  

        result.add(line.toString());  
        i = j;  
    }  

    return result;  
}

}
