// 230. Kth Smallest Element in a BST
class TreeNode 
{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) 
    {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Solution2 
{
    int count = 0;
    int answer = 0;

    public int kthSmallest(TreeNode root, int k) 
    {
        inorder(root, k);
        return answer;
    }

    public void inorder(TreeNode root, int k) 
    {
        if (root == null) return;

        // Visit left subtree
        inorder(root.left, k);

        // Visit current node
        count++;

        if (count == k) 
        {
            answer = root.val;
            return;
        }

        // Visit right subtree
        inorder(root.right, k);
    }
}

