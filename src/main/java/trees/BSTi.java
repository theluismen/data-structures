package trees;

import java.util.Set;

import exceptions.ElementNotFound;

public interface BSTi<T extends Comparable<T>> {

    /* Operaciones Básicas */
    void    insert ( T data );
    boolean search ( T data );
    void    delete ( T data ) throws ElementNotFound;

    /* Recorridos */
    Set<T> inorder();
    void   inorderShow();
    Set<T> preorder();
    void   preorderShow();
    Set<T> postorder();
    void   postorderShow();
    Set<T> levels();

    /* Operaciones Adicionales */
    T min();
    T max();
    T successor( T data ) throws ElementNotFound;
    // T predecessor(T data);
    // int height();
    int     size();
    boolean empty();
    void    clear();
    // boolean isBalanced();
}
