import java.util.*;

class Solution 
{
    // Inorder traversal
    public void inorder(TreeNode root, ArrayList<Integer> list) 
    {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }


    public int[] predecessorSuccessor(TreeNode root, int key) 
    {
        ArrayList<Integer> list = new ArrayList<>();

        // Get inorder traversal
        inorder(root, list);

        // Find key
        int index = list.indexOf(key);

        int predecessor = -1;
        int successor = -1;

        // Check left element
        if (index > 0) 
        {
            predecessor = list.get(index - 1);
        }

        // Check right element
        if (index < list.size() - 1) 
        {
            successor = list.get(index + 1);
        }

        return new int[]{predecessor, successor};
    }
}
