class Solution {
int maxSum = Integer.MIN_VALUE;

public int maxPathSum(TreeNode root) {  
    maxGain(root);  
    return maxSum;  
}  

private int maxGain(TreeNode node) {  
    if (node == null) {  
        return 0;  
    }  

    int left = Math.max(0, maxGain(node.left));  
    int right = Math.max(0, maxGain(node.right));  

    int currentSum = node.val + left + right;  

    maxSum = Math.max(maxSum, currentSum);  

    return node.val + Math.max(left, right);  
}

}
