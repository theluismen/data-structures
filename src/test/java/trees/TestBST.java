package trees;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestBST {

    @Test
    public void test_insert_1 () {
        BST<Integer> bst = new BST<>();
        for ( int i = 1; i <= 20; i++) {
            bst.insert( i );
        }
        assertEquals(20, bst.size());
    }
}
