/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return "null,";
        }
        String out = "";
        out += root.val + ",";
        out += serialize(root.left);
        out += serialize(root.right);
        return out;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        this.parseCounter = 0;
        return dsHelper(tokens);
    }
    
    private int parseCounter;
    
    private TreeNode dsHelper(String[] tokens){
        if(tokens[(int)parseCounter].equals("null")){
            parseCounter ++;
            return null;
        }
        TreeNode out = new TreeNode(Integer.parseInt(tokens[(int)parseCounter]));
        parseCounter ++;
        out.left = dsHelper(tokens);
        out.right = dsHelper(tokens);
        return out;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
