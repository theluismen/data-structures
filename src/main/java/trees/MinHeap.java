package trees;

public class MinHeap implements Heap {

    /*Atributos */
    private int[] array;
    private int   counter;
        
    /* Constructor */
    public MinHeap ( int size ) {
        this.array   = new int[size];
        this.counter = 0;
    }

    public void insert ( int data ) {
        int swap, p;

        /* Insertar data en el primer sitio libre */
        this.array[ this.counter ] = data;

        /* Mover hacia arriba si data es MENOR */
        p = this.counter;
        while ( this.array[ p / 2 ] > this.array[ p ] ) {
            swap                = this.array[ p / 2 ];
            this.array[ p / 2 ] = this.array[ p ];
            this.array[ p ]     = swap;
            p = p / 2;
        }
        
        this.counter++;
    }

    public int root ( ) {
        return this.array[0];
    }

    public void deleteRoot ( ) {
        int p, swap, lp;
        
        /* Remplazar root con el último */
        this.array[ 0 ] = this.array[ this.counter - 1 ];

        /* Eliminar el último */
        this.counter--;

        /* Heapify */
        p = 0;
        lp = 0;
        do {
            // Ver cual hijo es el MÍNIMO
            if ( this.array[ 2*p+1 ] < this.array[ 2*p+2 ] )
                lp = 2*p+1;
            else 
                lp = 2*p+2;
            

            // Cambiar Valores
            if ( this.array[ p ] > this.array[ lp ] ) { 
                swap = this.array[p];
                this.array[p] = this.array[lp];
                this.array[lp] = swap;
            }

            // Actualizar posición
            p = lp;
        } while ( this.array[ p ] > this.array[ lp ] );
    }

    public boolean empty ( ) {
        return true;
    }

    public int size() {
        return this.counter;
    }

}
