import java.util.*;

class BSTIterator 
{   
    List<Integer> list;
    int index=-1;

    public BSTIterator(TreeNode root) 
    {
        list = new ArrayList<Integer>();
        inorderTraversal(root);  //TC- O(n) SC- O(n)
    }

        
    public void inorderTraversal(TreeNode root) 
    {
        if(root == null) return;
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
    }
    
    public int next()   
    {
        // TC- O(1) SC- O(1)
        // initially index was point at -1 position
        index = index + 1;
        return list.get(index);
    }
    
    public boolean hasNext() 
    {
        // TC- O(1) SC- O(1)
        return index < list.size() - 1 ;
    }
}

