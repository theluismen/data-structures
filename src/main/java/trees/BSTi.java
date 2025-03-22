package trees;

import java.util.List;

public interface BSTi<T extends Comparable<T>> {

    // Operaciones básicas
    void    insert ( T data );
    boolean search ( T data );
    void    delete ( T data );

    // Recorridos
    List<T> inorder();
    void    inorderShow();
    List<T> preorder();
    void    preorderShow();
    List<T> postorder();
    void    postorderShow();
    List<T> levels();

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
