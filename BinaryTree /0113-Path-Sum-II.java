class Solution {
public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
List<List<Integer>> result = new ArrayList<>();
List<Integer> path = new ArrayList<>();

dfs(root, targetSum, path, result);  

    return result;  
}  

private void dfs(TreeNode node, int remaining,  
                 List<Integer> path, List<List<Integer>> result) {  
    if (node == null) {  
        return;  
    }  

    path.add(node.val);  
    remaining -= node.val;  

    if (node.left == null && node.right == null && remaining == 0) {  
        result.add(new ArrayList<>(path));  
    } else {  
        dfs(node.left, remaining, path, result);  
        dfs(node.right, remaining, path, result);  
    }  

    path.remove(path.size() - 1);  
}

}
