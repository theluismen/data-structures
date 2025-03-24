package trees;

import java.util.Set;

public interface BSTi<T extends Comparable<T>> {

    // Operaciones básicas
    void    insert ( T data );
    boolean search ( T data );
    void    delete ( T data );

    // Recorridos
    Set<T> inorder();
    void   inorderShow();
    Set<T> preorder();
    void   preorderShow();
    Set<T> postorder();
    void   postorderShow();
    Set<T> levels();

    // Operaciones adicionales
    // T findMin();
    // T findMax();
    // T successor(T data);
    // T predecessor(T data);
    // int height();
    int     size();
    boolean isEmpty();
    void    clear();
    // boolean isBalanced();
}
