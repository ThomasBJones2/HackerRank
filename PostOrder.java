/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        POHelper(root, out);
        return out;
    }
    
    public void POHelper(TreeNode root, List<Integer> out){
        if(root == null){
            return;
        }
        POHelper(root.left, out);
        POHelper(root.right,out);
        out.add(root.val);
    }
}
