
// 450. Delete Node in a BST

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    public TreeNode deleteNode(TreeNode root, int key) {

        // Tree/subtree is empty
        if (root == null) {
            return null;
        }

        // Key is smaller, so search in left subtree
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }

        // Key is larger, so search in right subtree
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }

        // We found the node
        else {

            // No left child
            if (root.left == null) {
                return root.right;
            }

            // No right child
            if (root.right == null) {
                return root.left;
            }

            // Two children
            // Find the smallest node in the right subtree
            TreeNode successor = root.right;

            while (successor.left != null) {
                successor = successor.left;
            }

            // Copy successor's value
            root.val = successor.val;

            // Delete the duplicate successor
            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }

    // Inorder traversal
    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) 
    {

        /*
                 5
                / \
               3   6
              / \   \
             2   4   7

             Delete 3
        */

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(7);

        System.out.println("Before deletion:");
        inorder(root);

        int key = 3;

        Solution obj = new Solution();
        root = obj.deleteNode(root, key);

        System.out.println("\nAfter deletion:");
        inorder(root);
    }
} // end of Solution
