package trees;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

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
    
    /* TEST .inorder() */

    @Test
    public void test_inorder_1 () {
        BST<Integer>  bst = new BST<>();
        
        for ( int i = 1; i <= 7; i++) {
            bst.insert( i );
        }

        bst.inorderShow();
        assert bst.inorder().equals( new ArrayList<>( Arrays.asList(1, 2, 3, 4, 5, 6, 7 ) ) );
    }
    
    /* TEST .preorder() */

    @Test
    public void test_preorder_1 () {
        BST<Integer>  bst = new BST<>();

        for ( int i = 1; i <= 7; i++) {
            bst.insert( i );
        }

        bst.preorderShow();
        assert bst.preorder().equals( new ArrayList<>( Arrays.asList( 4, 2, 1, 3, 6, 5, 7 ) ) );
    }
    
    /* TEST .postorder() */
    
    @Test
    public void test_postorder_1 () {
        BST<Integer>  bst = new BST<>();

        for ( int i = 1; i <= 7; i++) {
            bst.insert( i );
        }

        bst.postorderShow();
        assert bst.postorder().equals( new ArrayList<>( Arrays.asList( ) ) );
    }
}
