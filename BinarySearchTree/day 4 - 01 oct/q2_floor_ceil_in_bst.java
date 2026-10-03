//Floor wants the biggest smaller/equal value → when you find a valid value, move RIGHT to search for something bigger.

//Ceil wants the smallest greater/equal value → when you find a valid value, move LEFT to search for something smaller.

// Both take O(h) time.

// The iterative versions use O(1) extra space.

class Solution 
{
    int findFloor(Node root, int key) 
    {
        int floor = -1;

        while (root != null) 
        {
            if (root.data == key) {
                return root.data;
            }

            if (root.data < key) {
                floor = root.data;
                root = root.right;
            }
            else {
                root = root.left;
            }
        }

        return floor;
    }
}


class Solution2 
{
    int findCeil(Node root, int key) 
    {
        int ceil = -1;

        while (root != null) 
        {
            if (root.data == key) {
                return root.data;
            }

            if (root.data > key) {
                ceil = root.data;
                root = root.left;
            }
            else {
                root = root.right;
            }
        }

        return ceil;
    }
}