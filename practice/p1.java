class TreeNode 
{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) 
    {
        this.val = val;
    }
}

class Solution 
{
    public TreeNode helper(int[] preorder, int[] i, int bound) 
    {

        // No elements left
        // OR current value is greater than the allowed bound
        if (i[0] >= preorder.length || preorder[i[0]] > bound) 
        {
            return null;
        }

        // Create current node
        TreeNode root = new TreeNode(preorder[i[0]]);

        // Move to next preorder element
        i[0]++;

        // Construct left subtree
        root.left = helper(preorder, i, root.val);

        // Construct right subtree
        root.right = helper(preorder, i, bound);

        return root; 
    }

    public TreeNode bstFromPreorder(int[] preorder) 
    {
        int[] i = {0};
        return helper(preorder, i, Integer.MAX_VALUE);
     }
}

class Main 
{
    public static void main(String[] args) 
    {
        int[] preorder = {8, 5, 1, 7, 10, 12};

        Solution solution = new Solution();

        TreeNode root = solution.bstFromPreorder(preorder);

        System.out.println("BST constructed successfully.");
    }
}
