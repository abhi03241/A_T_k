class TreeNode 
{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) 
    { 
        this.val = val; 
    }

    TreeNode(int val, TreeNode left, TreeNode right) 
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution
{
    // Helper function
    public boolean helper(TreeNode root, TreeNode min, TreeNode max) 
    {
        // Empty tree is a valid BST
        if (root == null) 
            return true;

        // root must be greater than min
        if (min != null && root.val <= min.val) 
            return false;

        // root must be smaller than max
        if (max != null && root.val >= max.val) 
            return false;

        // Check left and right subtree
        return helper(root.left, min, root) && helper(root.right, root, max);
    }

    // Main function
    public boolean isValidBST(TreeNode root) 
    {
        return helper(root, null, null);
    }
}


