package trees;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class TestBST {

    /* TEST .insert() */
    
    @Test
    public void test_insert_1 () {
        BST<Integer> bst = new BST<>();
        
        for ( int i = 1; i <= 20; i++) {
            bst.insert( i );
        }
        
        assertEquals(20, bst.size());
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
}
