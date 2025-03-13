package trees;

public interface BSTi<T extends Comparable<T>> {

    // Operaciones básicas
    void insert(T data);
    boolean search(T data);
    void delete(T data);

    // Recorridos
    void inorder();
    void preorder();
    void postorder();
    void levels();

    // Operaciones adicionales
    // T findMin();
    // T findMax();
    // T successor(T data);
    // T predecessor(T data);
    // int height();
    int size();
    boolean isEmpty();
    void clear();
    // boolean isBalanced();
}
