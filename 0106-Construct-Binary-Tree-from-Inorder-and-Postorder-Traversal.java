class Solution {
private int postIndex;
private Map<Integer, Integer> map = new HashMap<>();

public TreeNode buildTree(int[] inorder, int[] postorder) {  
    postIndex = postorder.length - 1;  

    for (int i = 0; i < inorder.length; i++) {  
        map.put(inorder[i], i);  
    }  

    return build(inorder, postorder, 0, inorder.length - 1);  
}  

private TreeNode build(int[] inorder, int[] postorder, int left, int right) {  
    if (left > right) {  
        return null;  
    }  

    int value = postorder[postIndex--];  
    TreeNode root = new TreeNode(value);  

    int mid = map.get(value);  

    root.right = build(inorder, postorder, mid + 1, right);  
    root.left = build(inorder, postorder, left, mid - 1);  

    return root;  
}

}
