public class construcbinarytreepreorder {
    /*
    contruct the binary tree from the preorder traversal
    //binary sequence is left is smaller than root and right is bigger than root
    input:
    [8,5,1,7,10,12]
    output
    [8,5,10,1,7,null,12]
     */
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // Root of BST
    Node root;

    // Constructor
    construcbinarytreepreorder() {
        root = null;
    }

    // This method mainly calls insertRec()
    void insert(int key) {
        root = insertRec(root, key);
    }

    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root, int key) {

        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }

    // This method mainly calls InorderRec()
    void inorder() {
        inorderRec(root);
    }

    // A utility function to do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            System.out.println(root.key);
            inorderRec(root.left);

            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        construcbinarytreepreorder tree = new construcbinarytreepreorder();
        int arr[]=new int[]{8,5,1,7,10,12};
        for(int i:arr)
        {
            tree.insert(i);
        }
        tree.inorder();
    }
}
