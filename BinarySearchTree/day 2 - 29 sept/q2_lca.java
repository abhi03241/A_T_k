class Solution 
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        // Base case
        if (root == null) {
            return null;
        }

        // Both nodes are on the right
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // Both nodes are on the left
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        // One is on left and one is on right    i.e. p < root < q
        // OR root itself is p or q              i.e. root == p or root == q
        return root;
    }
}