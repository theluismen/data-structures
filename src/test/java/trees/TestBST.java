package trees;

import org.junit.jupiter.api.Test;

import exceptions.ElementNotFound;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;

public class TestBST {

    /* TEST .insert() */
    
    @Test
    public void test_insert_1 () {
        BST<Integer> bst = new BST<>();
        
        for ( int i = 1; i <= 20; i++) 
            bst.insert( i );
        
        assertEquals(20, bst.size());
    }

    @Test
    public void test_insert_2 () {
        BST<Integer> bst = new BST<>();
        
        bst.insert( 3 );
        bst.insert( 3 );
        bst.insert( 3 );
        
        assertEquals(1, bst.size());
    }
    
    /* TEST .search() */

    @Test
    public void test_search_1 () {
        BST<Integer> bst = new BST<>();
                
        assertEquals(false, bst.search(0));
    }

    @Test
    public void test_search_2 () {
        BST<Integer> bst = new BST<>();
        bst.insert(34);
        bst.insert(56);
        bst.insert(78);
        bst.insert(77);
        bst.insert(79);
        assertEquals(false, bst.search(80));
    }
    
    @Test
    public void test_search_3 () {
        BST<Integer> bst = new BST<>();
        bst.insert(34);
        bst.insert(56);
        bst.insert(78);
        bst.insert(77);
        bst.insert(79);
        assertEquals(true, bst.search(77));
    }

    @Test
    public void test_search_4 () {
        BST<Integer> bst = new BST<>();

        for (int i = 1; i <= 1000; i++) {
            bst.insert(i);
        }

        assertEquals(true, bst.search(333));
    }

    @Test
    public void test_search_5 () {
        BST<Integer> bst = new BST<>();

        for (int i = 1; i <= 1000; i++) 
            bst.insert(i);
        
        assertEquals(false, bst.search(2000));
    }
    
    /* TEST .delete() */
    
    @Test
    public void test_delete_0 () {
        BST<Integer> bst = new BST<>();

        bst.insert(5);
        bst.insert(2);
        bst.insert(1);
        bst.insert(4);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(9);
        bst.insert(10);
        
        assertThrows(ElementNotFound.class, () -> {
            bst.delete(11);
        });
    }
    
    @Test
    public void test_delete_1_1 () throws ElementNotFound {
        BST<Integer> bst = new BST<>();

        bst.insert(5);
        bst.delete(5);
        
        assertEquals(0, bst.size() );
    }
    
    @Test
    public void test_delete_1_2 () throws ElementNotFound {
        BST<Integer> bst = new BST<>();

        bst.insert(5);
        bst.insert(2);
        bst.insert(1);
        bst.insert(4);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(9);
        bst.insert(10);
        
        bst.delete(1);
        
        assertEquals(8, bst.size() );
    }
    
    @Test
    public void test_delete_1_3 () throws ElementNotFound {
        BST<Integer> bst = new BST<>();

        bst.insert(5);
        bst.insert(2);
        bst.insert(1);
        bst.insert(4);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(9);
        bst.insert(10);
        
        bst.delete(1);
        
        assert bst.preorder().equals( new HashSet<>( Arrays.asList(5, 2, 4, 3, 7, 12, 9, 10) ));
    }
    
    @Test
    public void test_delete_1_4 () throws ElementNotFound {
        BST<Integer> bst = new BST<>();
        
        bst.insert(5);
        bst.insert(2);
        bst.insert(1);
        bst.insert(4);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(9);
        bst.insert(10);
        
        bst.delete(10);
        
        assertEquals(8, bst.size() );
    }
    
    @Test
    public void test_delete_1_5 () throws ElementNotFound {
        BST<Integer> bst = new BST<>();

        bst.insert(5);
        bst.insert(2);
        bst.insert(1);
        bst.insert(4);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(9);
        bst.insert(10);
        
        bst.delete(10);
        
        assert bst.preorder().equals(new HashSet<>(Arrays.asList(5, 2, 1, 4, 3, 7, 12, 9)));
    }
    
    @Test
    public void test_delete_2_1 () throws ElementNotFound {
        BST<Integer> bst = new BST<>();

        bst.insert(5);
        bst.insert(6);
        bst.delete(5);

        assertEquals(1, bst.size());
    }
    
    @Test
    public void test_delete_2_2 () throws ElementNotFound {
        BST<Integer> bst = new BST<>();

        bst.insert(5);
        bst.insert(6);

        bst.delete(5);

        assertEquals(1, bst.size());
    }
    
    @Test
    public void test_delete_2_3 () throws ElementNotFound {
        BST<Integer> bst = new BST<>();

        bst.insert(5);
        bst.insert(6);

        bst.delete(5);

        assert bst.preorder().equals(new HashSet<>(Arrays.asList(6)));
    }

    @Test
    public void test_delete_2_4 () throws ElementNotFound {
        BST<Integer> bst = new BST<>();

        bst.insert(5);
        bst.insert(2);
        bst.insert(1);
        bst.insert(4);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(9);
        bst.insert(10);

        bst.delete(4);

        assertEquals(8, bst.size());
    }

    @Test
    public void test_delete_2_5 () throws ElementNotFound {
        BST<Integer> bst = new BST<>();

        bst.insert(5);
        bst.insert(2);
        bst.insert(1);
        bst.insert(4);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(9);
        bst.insert(10);

        bst.delete(4);

        assert bst.preorder().equals(new HashSet<>(Arrays.asList(5, 2, 1, 3, 7, 12, 9, 10)));
    }

    @Test
    public void test_delete_2_6 () throws ElementNotFound {
        BST<Integer> bst = new BST<>();

        bst.insert(5);
        bst.insert(2);
        bst.insert(1);
        bst.insert(4);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(9);
        bst.insert(10);

        bst.delete(7);

        assertEquals(8, bst.size());
    }

    @Test
    public void test_delete_2_7 () throws ElementNotFound {
        BST<Integer> bst = new BST<>();

        bst.insert(5);
        bst.insert(2);
        bst.insert(1);
        bst.insert(4);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(9);
        bst.insert(10);

        bst.delete(7);

        assert bst.preorder().equals(new HashSet<>(Arrays.asList(5, 2, 1, 4, 3, 12, 9, 10)));
    }
    
    @Test
    public void test_delete_3_0 () throws ElementNotFound {
        BST<Integer> bst = new BST<>();

        bst.insert(5);
        bst.insert(3);
        bst.insert(7);

        bst.delete(5);

        assertEquals(2, bst.size());
    }
    
    @Test
    public void test_delete_3_1 () throws ElementNotFound {
        BST<Integer> bst = new BST<>();

        bst.insert(5);
        bst.insert(3);
        bst.insert(7);

        bst.delete(5);

        assert bst.preorder().equals(new HashSet<>(Arrays.asList(7,3)));
    }
    
    @Test
    public void test_delete_3_2 () throws ElementNotFound {
        BST<Integer> bst = new BST<>();

        bst.insert(5);
        bst.insert(2);
        bst.insert(1);
        bst.insert(4);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(9);
        bst.insert(10);

        bst.delete(2);

        assertEquals(8, bst.size());
    }

    @Test
    public void test_delete_3_3 () throws ElementNotFound {
        BST<Integer> bst = new BST<>();

        bst.insert(5);
        bst.insert(2);
        bst.insert(1);
        bst.insert(4);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(9);
        bst.insert(10);

        bst.delete(2);

        assert bst.preorder().equals(new HashSet<>(Arrays.asList(5, 3, 1, 4, 7, 12, 9, 10)));
    }
    
    @Test
    public void test_delete_3_4 () throws ElementNotFound {
        BST<Integer> bst = new BST<>();

        bst.insert(5);
        bst.insert(2);
        bst.insert(1);
        bst.insert(4);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(9);
        bst.insert(10);

        bst.delete(5);

        assertEquals(8, bst.size());
    }

    @Test
    public void test_delete_3_5 () throws ElementNotFound {
        BST<Integer> bst = new BST<>();

        bst.insert(5);
        bst.insert(2);
        bst.insert(1);
        bst.insert(4);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(9);
        bst.insert(10);

        bst.delete(5);

        assert bst.preorder().equals(new HashSet<>(Arrays.asList(7, 2, 1, 4, 3, 12, 9, 10)));
    }

    /* TEST .inorder() */

    @Test
    public void test_inorder_1 () {
        BST<Integer>  bst = new BST<>();
        
        for ( int i = 1; i <= 7; i++) {
            bst.insert( i );
        }

        bst.inorderShow();
        assert bst.inorder().equals( new HashSet<>( Arrays.asList(1, 2, 3, 4, 5, 6, 7 ) ) );
    }
    
    /* TEST .preorder() */

    @Test
    public void test_preorder_1 () {
        BST<Integer>  bst = new BST<>();

        for ( int i = 1; i <= 7; i++) {
            bst.insert( i );
        }
        System.out.println("gei");
        bst.preorderShow();
        assert bst.preorder().equals( new HashSet<>( Arrays.asList( 4, 2, 1, 3, 6, 5, 7 ) ) );
    }
    
    /* TEST .postorder() */
    
    @Test
    public void test_postorder_1 () {
        BST<Integer>  bst = new BST<>();

        for ( int i = 1; i <= 7; i++) {
            bst.insert( i );
        }

        bst.postorderShow();
        assert bst.postorder().equals( new HashSet<>( Arrays.asList( 4, 5, 2, 6, 7, 3, 1 ) ) );
    }
    
    /* TEST .levels() */
    
    @Test
    public void test_levels_1 () {
        BST<Integer>  bst = new BST<>();

        for ( int i = 1; i <= 10; i++) 
            bst.insert( i );
        
        assert bst.levels().equals( new HashSet<>( Arrays.asList( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ) ) );
    }
    
    @Test
    public void test_levels_2 () {
        BST<Integer>  bst = new BST<>();

        bst.insert(5);
        bst.insert(2);
        bst.insert(1);
        bst.insert(4);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(9);
        bst.insert(10);

        assert bst.levels().equals( new HashSet<>( Arrays.asList( 5, 2, 7, 1, 4, 12, 3, 9, 10 ) ) );
    }

    /* TEST .min() */
    
    @Test
    public void test_min_1 () {
        BST<Integer>  bst = new BST<>();
        
        for ( int i = 100; i <= 500; i++) {
            bst.insert( i );
        }
        
        assertEquals(100, bst.min() );
    }
    
    /* TEST .max() */
    
    @Test
    public void test_max_1 () {
        BST<Integer>  bst = new BST<>();

        for ( int i = 100; i <= 500; i++) {
            bst.insert( i );
        }

        assertEquals(500, bst.max() );
    }
    
    /* TEST .successor() */
    
    @Test
    public void test_successor_1 () throws ElementNotFound {
        BST<Integer>  bst = new BST<>();

        bst.insert( 5 );
        bst.insert( 2 );
        bst.insert( 1 );
        bst.insert( 4 );
        bst.insert( 3 );
        bst.insert( 7 );
        bst.insert( 12 );
        bst.insert( 9 );
        bst.insert( 10 );
        
        assertEquals(2, bst.successor(1) );
    }
    
    @Test
    public void test_successor_2 () throws ElementNotFound {
        BST<Integer>  bst = new BST<>();

        bst.insert( 5 );
        bst.insert( 2 );
        bst.insert( 1 );
        bst.insert( 4 );
        bst.insert( 3 );
        bst.insert( 7 );
        bst.insert( 12 );
        bst.insert( 9 );
        bst.insert( 10 );

        assertEquals(3, bst.successor(2) );
    }
    
    @Test
    public void test_successor_3 () throws ElementNotFound {
        BST<Integer>  bst = new BST<>();

        bst.insert( 5 );
        bst.insert( 2 );
        bst.insert( 1 );
        bst.insert( 4 );
        bst.insert( 3 );
        bst.insert( 7 );
        bst.insert( 12 );
        bst.insert( 9 );
        bst.insert( 10 );

        assertEquals(12, bst.successor(10) );
    }
    
    @Test
    public void test_successor_4 () throws ElementNotFound {
        BST<Integer>  bst = new BST<>();

        bst.insert( 5 );
        bst.insert( 2 );
        bst.insert( 1 );
        bst.insert( 4 );
        bst.insert( 3 );
        bst.insert( 7 );
        bst.insert( 12 );
        bst.insert( 9 );
        bst.insert( 10 );

        assertThrows(ElementNotFound.class, () -> { 
            bst.successor(11);
        });
    }
}
