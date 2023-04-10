public class BST
{
    BST tree;
    Node root;

    public void insert(String key)
    {
        // if(root.key.compareTo(key) < 0)
        {
            // 
            root = insertHelper(root, key);
        }
    }

    public Node insertHelper(Node node, String key)
    {
        /*
         * Base case:
         * 
         * if node left child is after new node
         * then set the current left child to be the right child
         * and the current right child to be the new right child's, left child
         * and the new node to be the left child
         */

        if(node == null)
        {
            root = new Node(key);
            return root;
        }

        else if(node.key.compareTo(key) > 0)
        {
            return insertHelper(node.left, key);
        }

        else if(node.key.compareTo(key) < 0)
        {
            return insertHelper(node.right, key);
        }

        return node;
    }

    public void delete(String key)
    {

    }

    public Node search(Node root, String key)
    {
        // if root is search node or root is null, return root
        if(root.key.compareTo(key) == 0 || root == null)
            return root;
        
        // if root left child is before search node, scrap right subtree
        if(root.left.key.compareTo(key) > 0)
            return search(root.left, key);

        // otherwise, scrap the left subtree
        return search(root.right, key);
    }
}