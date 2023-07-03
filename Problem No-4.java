
💡 **Question 4**

You need to construct a binary tree from a string consisting of parenthesis and integers.

The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.
You always start to construct the **left** child node of the parent first if it exists.

**Input:** s = "4(2(3)(1))(6(5))"

**Output:** [4,2,6,3,1,5]

soln : //time complexity:O(n);
       //space complexity :O(n);

    public class Solution {
    private int index; // Global index to keep track of the current position in the string
    
    public TreeNode str2tree(String s) {
        if (s.isEmpty()) {
            return null;
        }
        
        // Find the root value
        int end = s.indexOf('(');
        if (end == -1) {
            return new TreeNode(Integer.parseInt(s));
        }
        
        // Create the root node
        int rootValue = Integer.parseInt(s.substring(0, end));
        TreeNode root = new TreeNode(rootValue);
        
        // Find the start and end indices of the left and right subtrees
        int start = end;
        int openCount = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (c == '(') {
                openCount++;
            } else if (c == ')') {
                openCount--;
            }
            if (openCount == 0) {
                break;
            }
            end++;
        }
        
        // Construct the left subtree recursively
        root.left = str2tree(s.substring(start + 1, end));
        
        // Construct the right subtree recursively if it exists
        if (end + 2 < s.length()) {
            root.right = str2tree(s.substring(end + 2, s.length() - 1));
        }
        
        return root;
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }
    
    private void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        
        inorderHelper(node.left, result);
        result.add(node.val);
        inorderHelper(node.right, result);
    }
}
