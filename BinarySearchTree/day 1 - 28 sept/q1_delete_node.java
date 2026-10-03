
// 450. Delete Node in a BST
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

class Solution1
{
    public TreeNode deleteNode(TreeNode root, int key) 
    {
        // Tree/subtree is empty
        if (root == null) return null;

        // Key is smaller, so search in left subtree
        if (key < root.val) 
        {
            root.left = deleteNode(root.left, key);
        }

        // Key is larger, so search in right subtree
        else if (key > root.val) 
            {
                root.right = deleteNode(root.right, key);
            }

            // We found the node
            else 
            {
                // No left child
                if (root.left == null) 
                {
                    return root.right;
                }

                // No right child
                if (root.right == null) 
                {
                    return root.left;
                }

                // Two children
                // Find the smallest node in the right subtree
                TreeNode successor = root.right;

                while (successor.left != null) 
                {
                  successor = successor.left;
                }

                // Copy successor's value
                root.val = successor.val;

                // Delete the duplicate successor
                root.right = deleteNode(root.right, successor.val);
            }
        return root;
    }
}
