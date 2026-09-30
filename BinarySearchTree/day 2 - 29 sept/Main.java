

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

public class Main {

    // Helper function
    public static boolean helper(TreeNode root, TreeNode min, TreeNode max) {

        // Empty tree is a valid BST
        if (root == null) {
            return true;
        }

        // root must be greater than min
        if (min != null && root.val <= min.val) {
            return false;
        }

        // root must be smaller than max
        if (max != null && root.val >= max.val) {
            return false;
        }

        // Check left and right subtree
        return helper(root.left, min, root) && helper(root.right, root, max);
    }

    // Main function
    public static boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    // Inorder traversal just to display the tree
    public static void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);

        System.out.print(root.val + " ");

        inorder(root.right);
    }

    public static void main(String[] args) {

        /*
                  5
                 / \
                3   7
               / \   \
              2   4   8
        */

        // Create root
        TreeNode root = new TreeNode(5);

        // Left and right of 5
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);

        // Children of 3
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        // Right child of 7
        root.right.right = new TreeNode(8);

        // Display inorder
        System.out.println("Inorder traversal:");
        inorder(root);

        // Check whether it is a valid BST
        boolean result = isValidBST(root);

        System.out.println("Is this a valid BST? " + result);
    }
}