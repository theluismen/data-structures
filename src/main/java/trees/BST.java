package trees;

public class BST <T extends Comparable<T>> implements BSTi<T> {

    // Clase Nodo
    private class Node {
        /* Atributos */
        private T       data;
        private Node    left;
        private Node    right;

        /* Constructor */
        public Node(T data) {
            this.data   = data;
            this.left   = null;
            this.right  = null;
        }

        /* Metodos */
        public boolean isLeaf () {
            return this.left == null && this.right == null;
        }

        // Getters
        public T getData() {
            return this.data;
        }

        public Node getLeft() {
            return this.left;
        }

        public Node getRight() {
            return this.right;
        }

        // Setters
        public void setData(T data) {
            this.data = data;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    /* Atributos */
    private Node root;
    private int nElem;

    /* Constructor */
    public BST () {
        this.root = null;
    }

    /* Métodos */

    public void insert ( T data ) {
        Node node = this.root;

        if ( this.root == null ) {
            this.root = new Node( data );
        } else {
            while ( ! node.isLeaf() ) {
                if ( data.compareTo( node.getData() ) < 0 ) {
                    node = node.getLeft();
                }
                if ( data.compareTo( node.getData() ) > 0 ) {
                    node = node.getRight();
                }
            }
            if ( data.compareTo( node.getData() ) < 0 ) {
                node.setLeft( new Node( data ) );
            }
            if ( data.compareTo( node.getData() ) > 0 ) {
                node.setRight( new Node( data ) );
            }
        }

        this.nElem ++;
    }

    public boolean search ( T data ) {
        return false;
    }

    public void delete( T data ) {

    }

    public void inorder() {

    }

    public void preorder() {

    }

    public void postorder() {

    }

    public void levels() {

    }

    public int size() {
        return this.nElem;
    }

    public boolean isEmpty() {
        return this.nElem == 0;
    }

    public void clear() {

    }

}
