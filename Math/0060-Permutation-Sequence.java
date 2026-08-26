import java.util.*;

class Solution {
public String getPermutation(int n, int k) {

List<Integer> numbers = new ArrayList<>();  

      
    for (int i = 1; i <= n; i++) {  
        numbers.add(i);  
    }  

     
    int fact = 1;  

    for (int i = 1; i < n; i++) {  
        fact = fact * i;  
    }  

      
    k = k - 1;  

    StringBuilder ans = new StringBuilder();  

    while (n > 0) {  

          
        int index = k / fact;  

        ans.append(numbers.get(index));  
        numbers.remove(index);  

          
        k = k % fact;  

        n--;  

          
        if (n > 0) {  
            fact = fact / n;  
        }  
    }  

    return ans.toString();  
}

}
