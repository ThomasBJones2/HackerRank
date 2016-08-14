/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * This piece of code finds all possible
 * BST on numbers from 1 to 10
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new ArrayList<TreeNode>();
        }
        return genTreeH(1,n);
    }
    
    List<TreeNode> genTreeH(int bot, int top){
        ArrayList<TreeNode> out = new ArrayList<>();
        if(bot > top){
            out.add(null);
            return out;
        }
        if(bot == top){
            out.add(new TreeNode(bot));
            return out;
        }

        for(int i = bot; i <= top; i ++){            
            List<TreeNode> lefts = genTreeH(bot, i - 1);
            List<TreeNode> rights = genTreeH(i + 1, top);
            for(int j = 0; j < lefts.size(); j ++){
                for(int k = 0; k < rights.size(); k ++){
                    TreeNode nextNode = new TreeNode(i);
                    nextNode.left = lefts.get(j);
                    nextNode.right = rights.get(k);
                    out.add(nextNode);
                }
            }
        }
        return out;
    }
}
