class Solution {

    public TreeNode helper(int[] preorder, int[] i, int bound) {

        // Stop if:
        // 1. We reached the end of the array
        // 2. Current value is greater than the allowed bound
        if (i[0] >= preorder.length || preorder[i[0]] > bound) {
            return null;
        }

        // Create the current node
        TreeNode root = new TreeNode(preorder[i[0]]);

        // Move to the next preorder element
        i[0]++;

        // Build left subtree
        root.left = helper(preorder, i, root.val);

        // Build right subtree
        root.right = helper(preorder, i, bound);

        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {

        // i must be shared by all recursive calls
        int[] i = {0};

        // Initially, any value up to Integer.MAX_VALUE is allowed
        return helper(preorder, i, Integer.MAX_VALUE);
    }
}