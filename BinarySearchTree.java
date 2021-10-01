public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {
    //<E extends Comparable<E> is very important so the tree can work
    //Needs compareTo method to be defined

    public BinarySearchTree() {

    }
    public BinarySearchTree(E val) {

    }

    // returns true if BST has val else false.
    public boolean contains (E val) {
        Node<E> currentNode = root;
        while(currentNode != null) { // Or whatever you use to signal that there is no node.
            switch(val.compareTo(currentNode.getInfo())) {
                case -1:
                    currentNode = currentNode.getRight();
                    break;
                case 1:
                    currentNode = currentNode.getLeft();
                    break;
                default: // case 0
                    return true;
            }
        }
        return false;
    }
    // inserts val at the right place satisfying search tree properties, should handle if the tree is empty
// if value is already there then donâ€™t insert it again
    public void insert(E val) {
        Node<E> newNode = new Node(val);
        if(root == null)
        {
            root = newNode;
        }
        else
            {
            Node current = root;
            Node parent;
            while(true)
                {

                parent = current;
                if((int)val < (int)current.getInfo())
                {
                    current = current.left;
                    if(current == null)
                    {
                        parent.left = newNode;
                        return;
                    }
                }
                else
                    {
                    current = current.right;
                    if(current == null)
                    {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    // returns the minimum value stored in the tree
    //All the way on the left of binary search tree
    //no left of root, root is smallest
    public int findMin(Node<E> ctf) {
        Node<E> node = ctf;
        Node<E> left = node.getLeft();
        Node<E> right = node.getRight();
        if (node == null)
            return (int)node.getInfo();

        int res = (int)node.getInfo();
        int lres = findMin(left);
        int rres = findMin(right);

        if (lres < res)
            res = lres;
        if (rres < res)
            res = rres;
        return res;

    }

    // returns the maximum value stored in the tree
    //All the way on the right of binary search tree
    public int findMax(Node<E> ctf) {
        Node<E> node = ctf;
        Node<E> left = node.getLeft();
        Node<E> right = node.getRight();
        if (node == null)
            return (int)node.getInfo();

        int res = (int)node.getInfo();
        int lres = findMax(left);
        int rres = findMax(right);

        if (lres > res)
            res = lres;
        if (rres > res)
            res = rres;
        return res;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bt= new BinarySearchTree<>();
        bt.insert(5);
        bt.insert(10);
        bt.insert(3);
        bt.insert(20);
        bt.insert(8);
        bt.insert(4);
    }


}