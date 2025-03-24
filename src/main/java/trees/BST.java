package trees;

import java.util.HashSet;
import java.util.Set;

import exceptions.ElementNotFound;

public class BST <T extends Comparable<T>> implements BSTi<T> {

    /* Clase Nodo */
    private class Node {
        /* Atributos */
        private T       data;
        private Node    father;
        private Node    left;
        private Node    right;

        /* Constructor */
        public Node( T data ) {
            this.data   = data;
            this.father = null;
            this.left   = null;
            this.right  = null;
        }

        /* Metodos */
        public int nChildren () {
            int n = 0;
            if ( this.left != null ) 
                n++;
            if ( this.right != null ) 
                n++;
            return n;
        }

        // Getters
        public T getData() {
            return this.data;
        }

        public Node getFather () {
            return this.father;
        }

        public Node getLeft() {
            return this.left;
        }

        public Node getRight() {
            return this.right;
        }

        // Setters
        /* public void setData(T data) {
            this.data = data;
        } */

        public void setFather(Node father) {
            this.father = father;
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

    /* Operaciones Básicas */

    public void insert ( T data ) {
        Node node, newNode;

        // Si esta vacio inicializo la root con la data
        if ( this.root == null ) {
            this.root = new Node( data );
            this.nElem ++;
            return;
        } 

        node = this.root;

        // Si no, recorro arbol hasta que encuentre una hoja
        while ( true ) {
            // Si hay un repetido, me la suda
            if ( data.compareTo(node.getData()) == 0 ) 
                return;
            
            if ( data.compareTo( node.getData() ) < 0 ) {
                if ( node.getLeft() == null ) 
                    break;
                node = node.getLeft();
            }

            if ( data.compareTo( node.getData() ) > 0 ) {
                if ( node.getRight() == null ) 
                    break;
                node = node.getRight();
            }
        }

        // Crear Nodo Hijo enlazado al padre (node)
        newNode = new Node ( data );
        newNode.setFather( node );

        if ( data.compareTo( node.getData() ) < 0 ) 
            node.setLeft( newNode );
        
        if ( data.compareTo( node.getData() ) > 0 ) 
            node.setRight( newNode );
        
        this.nElem ++;
    }

    public boolean search ( T data ) {
        Node node = this.root;
        
        while ( node != null ) {
            if ( data.compareTo( node.getData() ) == 0 )
                return true;
            if ( data.compareTo( node.getData() ) <  0 )
                node = node.getLeft();
            if ( data.compareTo( node.getData() ) >  0 )
                node = node.getRight();
        }

        return false;
    }

    public void delete( T data ) throws ElementNotFound {
        Node node;
        
        /* Buscar Nodo */
        try {
            node = this.get( data );
        } catch ( ElementNotFound e ) {
            throw new ElementNotFound();
        }

        /* Nodo a borrar es una hoja */
        if ( node.nChildren() == 0 ) {
            if ( node.getFather().getData().compareTo( node.getData() ) <= 0  ) {
                node.getFather().setRight( null );
            } else {
                node.getFather().setLeft( null );
            }
            node.setFather(null);
            return;
        }

        /* Nodo a borrar tiene un hijo */

    }

    private Node get ( T data ) throws ElementNotFound {
        Node node = this.root;

        while ( node != null ) {
            if ( data.compareTo( node.getData() ) == 0 )
                return node;
            if ( data.compareTo( node.getData() ) < 0 )
                node = node.getLeft();
            if ( data.compareTo( node.getData() ) > 0 )
                node = node.getRight();
        }

        throw new ElementNotFound();
    }

    /* Recorridos */

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
    
    /* Operaciones Adicionales */

    public T min () {
        return ( this.root == null ) ? null: min( this.root );
    }

    private T min ( Node node ) {
        Node n = node;
        
        while ( true ) {
            if ( n.getLeft() == null )
                break;
            n = n.getLeft();
        }

        return n.getData();
    }

    public T max ( ) {
        return ( this.root == null ) ? null: max( this.root );
    }

    private T max ( Node node ) {
        Node n = node;
        
        while ( true ) {
            if ( n.getRight() == null )
                break;
            n = n.getRight();
        }

        return n.getData();
    }

    public T successor ( T data ) throws ElementNotFound {
        Node node;
        
        /* Buscar Nodo */
        try {
            node = this.get( data );
        } catch ( ElementNotFound e ) {
            throw new ElementNotFound();
        }

        /* Si tiene subarbol derecho, devolver mínimo */
        if ( node.getRight() != null ) 
            return this.min( node.getRight() );
        
        /* Si no tiene, ir hacia arriba hasta encontrar uno mayor */
        while ( node.getFather().getData().compareTo( node.getData() ) <= 0 ) {
            node = node.getFather();
        }

        return node.getFather().getData();
    }  

    public int size ( ) {
        return this.nElem;
    }

    public boolean empty ( ) {
        return this.root == null;
    }

    public void clear ( ) {

    }
}
