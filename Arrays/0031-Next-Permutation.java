class Solution {
public void nextPermutation(int[] nums) {

int i = nums.length - 2;  

    // Step 1: Find first decreasing element  
    while (i >= 0 && nums[i] >= nums[i + 1]) {  
        i--;  
    }  

    // Step 2: Find just greater element and swap  
    if (i >= 0) {  
        int j = nums.length - 1;  

        while (nums[j] <= nums[i]) {  
            j--;  
        }  

        swap(nums, i, j);  
    }  

    // Step 3: Reverse the remaining part  
    reverse(nums, i + 1, nums.length - 1);  
}  

public void swap(int[] nums, int i, int j) {  
    int temp = nums[i];  
    nums[i] = nums[j];  
    nums[j] = temp;  
}  

public void reverse(int[] nums, int left, int right) {  
    while (left < right) {  
        swap(nums, left, right);  
        left++;  
        right--;  
    }  
}

}
