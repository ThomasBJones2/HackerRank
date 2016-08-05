import java.util.HashMap;

/**
 * This is a nifty little dynamic programming example
 * for finding which houses could be robbed on a binary
 * tree (seriously, that was the question) without causing
 * the police to be called. If any two adjacent houses are robbed the
 * police will be called.
 *
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    HashMap<TreeNode, Integer> recordRob;
    HashMap<TreeNode, Integer> recordNotRob;
    
    public int rob(TreeNode root) {
       int out = 0;
       recordRob = new HashMap<>();
       recordNotRob = new HashMap<>();
       out = robHelper(root, false);
       return out;
    }
    
    int robHelper(TreeNode root, boolean parRob){
        if(root == null) {
            return 0;
        }
        
        int notRobbed = 0;
        if(recordNotRob.get(root) != null) {
            notRobbed = recordNotRob.get(root);
        } else {
            notRobbed = robHelper(root.right, false) + robHelper(root.left, false);
            recordNotRob.put(root, notRobbed);
        }
        
        if(parRob == true) {
            return notRobbed;
        }
        
        int robbed = 0;
        if(recordRob.get(root) != null){
            robbed = recordRob.get(root);
        } else {
            robbed = root.val + robHelper(root.right, true) + robHelper(root.left, true);
            recordRob.put(root, robbed);
        }
        return Math.max(robbed, notRobbed);
    }
}
