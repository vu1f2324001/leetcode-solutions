class Solution {
TreeNode first = null;
TreeNode second = null;
TreeNode prev = null;

public void recoverTree(TreeNode root) {  
    TreeNode curr = root;  

    while (curr != null) {  
        if (curr.left == null) {  
            check(curr);  
            curr = curr.right;  
        } else {  
            TreeNode pred = curr.left;  

            while (pred.right != null && pred.right != curr) {  
                pred = pred.right;  
            }  

            if (pred.right == null) {  
                pred.right = curr;  
                curr = curr.left;  
            } else {  
                pred.right = null;  
                check(curr);  
                curr = curr.right;  
            }  
        }  
    }  

    int temp = first.val;  
    first.val = second.val;  
    second.val = temp;  
}  

private void check(TreeNode node) {  
    if (prev != null && prev.val > node.val) {  
        if (first == null) {  
            first = prev;  
        }  

        second = node;  
    }  

    prev = node;  
}

}
