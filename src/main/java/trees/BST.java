package trees;

import java.util.HashSet;
import java.util.Set;

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
        this.root  = null;
        this.nElem = 0;
    }

    /* Métodos */

    public void insert ( T data ) {
        Node node = this.root;

        // Si esta vacio inicializo la root con la data
        if ( this.root == null ) {
            this.root = new Node( data );
        } else {
            // Si no, recorro arbol hasta que encuentre una hoja
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

    public Set<T> inorder ( ) {
        return this.inorderHelper( this.root, new HashSet<>() );
    }

    private Set<T> inorderHelper ( Node node, Set<T> set ) {
        
        if ( node != null ) {
            inorderHelper( node.getLeft(), set);
            set.add(node.getData());
            inorderHelper( node.getRight(), set);
        }

        return set;
    }

    public void inorderShow ( ) {
        this.inorderShowHelper( this.root );
    }
    
    private void inorderShowHelper ( Node node ) {
        if ( node != null ) {
            inorderShowHelper( node.getLeft() );
            System.out.println( node.getData() );
            inorderShowHelper( node.getRight() );
        }
    }

    public Set<T> preorder ( ) {
        return this.preorderHelper( this.root, new HashSet<>());
    }
    
    private Set<T> preorderHelper ( Node node, Set<T> set ) {
        
        if ( node != null ) {
            set.add( node.getData() );
            preorderHelper( node.getLeft(), set );
            preorderHelper( node.getRight(), set );
        }

        return set;
    }

    public void preorderShow ( ) {
        this.preorderShowHelper( this.root );
    }

    private void preorderShowHelper ( Node node ) {
        if ( node != null ) {
            System.out.println( node.getData() );
            preorderShowHelper( node.getLeft() );
            preorderShowHelper( node.getRight() );
        }
    }

    public Set<T> postorder() {
        return this.postorderHelper( this.root, new HashSet<>() );
    }

    private Set<T> postorderHelper ( Node node, Set<T> set ) {

        if ( node != null ) {
            preorderHelper( node.getLeft(), set );
            preorderHelper( node.getRight(), set );
            set.add( node.getData() );
        }

        return set;
    }
    
    public void postorderShow() {
        this.postorderShowHelper( this.root );
    }

    private void postorderShowHelper ( Node node ) {
        if ( node != null ) {
            preorderShowHelper( node.getLeft() );
            preorderShowHelper( node.getRight() );
            System.out.println( node.getData() );
        }
    }

    public Set<T> levels() {
        return null;
    }

    public int size ( ) {
        return this.nElem;
    }

    public boolean isEmpty ( ) {
        return this.nElem == 0;
    }

    public void clear ( ) {

    }


}
