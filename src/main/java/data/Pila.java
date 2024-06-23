package data;

import data.exceptions.Pila_Llena;
import data.exceptions.Pila_Vacia;
import data.interfaces.I_Pila;

public class Pila<T> implements I_Pila<T> {
    // Clase Abstracta con metodos iguales para la implementacion Estatica y Dinamica
    private abstract class Pila_Generica {
        /* ATRIBUTOS */
        private int nElem; // Numero de elementos guardados
        private int mida;
        
        /* CONSTRUCTOR */
        public Pila_Generica(int mida) {
            this.mida  = mida;
            this.nElem = 0;
        }

        // Metodo que devuelve el NUMERO de ELEMENTOS
        public int numElems() {
            return this.nElem;
        }

        // Metodo que devuelve si la Pila esta LLENA o no
        public boolean esLlena() {
            return this.nElem == this.mida;
        }

        // Metodo que devuelve si la Pila esta VACIA o no
        public boolean esVacia() {
            return this.nElem == 0;
        }

        // Metodo que DECREMENTA el numero de elementos
        public void decNumElems() {
            this.nElem--;
        }

        // Metodo que INCREMENTA el numero de elementos
        public void incNumElems() {
            this.nElem++;
        }
    }
    
    // Clase para la implementacion Estatica 
    private class Pila_Estatica<U> extends Pila_Generica implements I_Pila<U> {
        /* ATRIBUTOS */
        private U[] elements; // Los elementos que guardo ( array de N posiciones)

        /* CONSTRUCTOR */
        @SuppressWarnings("unchecked")
        public Pila_Estatica(int mida) {
            super(mida);
            this.elements = (U[]) new Object[mida];
        }

        // Metodo que APILA un elemento en la cima de la pila
        public void apilar(U elem) throws Pila_Llena {
            if ( this.esLlena() )
                throw new Pila_Llena();

            this.elements[super.numElems()] = elem;
            super.incNumElems();
        }

        // Metodo que DESAPILA elemento en la cima de la pila
        public void desapilar() throws Pila_Vacia {
            if ( this.esVacia() )
                throw new Pila_Vacia();

            super.decNumElems();
        }

        // Metodo que devuelve el elemento que ESTA EN LA CIMA
        public U cima() throws Pila_Vacia {
            if ( this.esVacia() )
                throw new Pila_Vacia();

            return this.elements[super.numElems() - 1];
        }
    }
    
    // Clase para la implementacion Dinamica
    private class Pila_Dinamica<U> extends Pila_Generica implements I_Pila<U> {
        // Clase Nodo 
        private class Nodo<V> {
            /* ATRIBUTOS */
            private V       data;
            private Nodo<V> next;

            /* CONSTRUCTOR */
            public Nodo ( V data, Nodo<V> next ) {  // Constructor principal
                this.data = data;   
                this.next = next;
            }
            
            /* public Nodo ( V data ) { // Constructor secundario
                this.data = data;
                this.next = null;
            } */

            // Metodo que devuelve la informacion nodo
            public V getData () {
                return this.data;
            }
            
            // Metodo que devuelve la direccion del nodo
            public Nodo<V> getNext () {
                return this.next;
            }

            // Metodo que modifica el Nodo ( this.next ) al que apunta el Nodo 
            public void setNext ( Nodo<V> next ) {
                this.next = next;               
            } 
        }
        
        /* ATRIBUTOS */
        private Nodo<U> head;

        /* CONSTRUCTOR */
        public Pila_Dinamica( int mida ) {
            super(mida);
            this.head = new Nodo<>(null, null);
        }

        // Metodo que APILA un elemento en la cima de la pila
        public void apilar( U elem ) throws Pila_Llena {
            Nodo<U> nuevo;

            if ( this.esLlena() ) 
                throw new Pila_Llena();

            nuevo = new Nodo<>(elem, this.head.getNext() ); // Creo el nuevo nodo con el elem
            this.head.setNext( nuevo );                     // Actualizo el head al nuevo nodo
            incNumElems();
        }

        // Metodo que DESAPILA elemento en la cima de la pila
        public void desapilar() throws Pila_Vacia {
            Nodo<U> nodo;
            
            if ( this.esVacia() )
                throw new Pila_Vacia();

            nodo = this.head.getNext();          // Del nodo que esta en la cima
            this.head.setNext( nodo.getNext() ); // que el this.head señale a lo que señala el nodo
            nodo.setNext( null );           // y que el nodo quede colgando 

            decNumElems();
        }

        // Metodo que devuelve el elemento que ESTA EN LA CIMA
        public U cima() throws Pila_Vacia {
            if ( this.esVacia() )
                throw new Pila_Vacia();
            return this.head.getNext().getData();
        }
    }
    
    /* ATRIBUTOS */
    private I_Pila<T> pila;

    /* CONSTRUCTOR */
    public Pila ( boolean tipo, int mida ) {
        if ( tipo == false ) {  // false ==> Mem Estatica
            this.pila = new Pila_Estatica<T>( mida );
        } else {                // true  ==> Mem Dinamica
            this.pila = new Pila_Dinamica<T>( mida );
        }
    }

    // Metodo que APILA un elemento en la cima de la pila
    public void apilar ( T elem ) throws Pila_Llena {
        this.pila.apilar( elem );
    }

    // Metodo que DESAPILA elemento en la cima de la pila
    public void desapilar ( ) throws Pila_Vacia {
        this.pila.desapilar();
    }

    // Metodo que devuelve el elemento que ESTA EN LA CIMA
    public T cima () throws Pila_Vacia {
        return this.pila.cima();
    }

    // Metodo que devuelve el NUMERO de ELEMENTOS
    public int numElems () {
        return this.pila.numElems();
    }

    // Metodo que devuelve si la Pila esta LLENA o no
    public boolean esLlena () {
        return this.pila.esLlena();
    }

    // Metodo que devuelve si la Pila esta VACIA o no
    public boolean esVacia () {
        return this.pila.esVacia();
    }
}
