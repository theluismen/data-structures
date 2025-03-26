package trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestHeap {

    /* TEST .insert() */
    
    @Test
    public void test_insert_1 () {
        Heap heap = new MinHeap(10);
        
        for ( int i = 1; i < 10; i++) 
            heap.insert( i );
        
        assertEquals(9, heap.size());
    }
    
    @Test
    public void test_insert_2 () {
        Heap heap = new MinHeap(10);
        
        for ( int i = 10; i >= 1; i-- ) 
            heap.insert( i );
        
        assertEquals(1, heap.root());
    }
    
    @Test
    public void test_insert_3 () {
        Heap heap = new MinHeap(40);
        
        for ( int i = 20; i >= 10; i-- ) 
            heap.insert( i );

        for ( int i = 4; i <= 9; i++ ) 
            heap.insert( i );
        
        assertEquals(4, heap.root());
    }
    
    /* TEST .deleteRoot() */

    @Test
    public void test_deleteRoot_1 () {
        Heap heap = new MinHeap(40);
        
        for ( int i = 20; i >= 10; i-- ) 
            heap.insert( i );
        
        heap.deleteRoot();

        assertEquals(11, heap.root());
    }

}
