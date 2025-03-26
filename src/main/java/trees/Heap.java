package trees;

public interface Heap {
    int     size ( );
    int     root ( );
    boolean empty ( );
    void    insert ( int data );
    void    deleteRoot ( );
}
