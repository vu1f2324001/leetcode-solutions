class Solution {
public int sumNumbers(TreeNode root) {
return calculate(root, 0);
}

private int calculate(TreeNode node, int sum) {  
    if (node == null) {  
        return 0;  
    }  

    sum = sum * 10 + node.val;  

    if (node.left == null && node.right == null) {  
        return sum;  
    }  

    return calculate(node.left, sum)  
         + calculate(node.right, sum);  
}

}
