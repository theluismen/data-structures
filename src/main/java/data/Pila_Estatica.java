package data;

import data.exceptions.Pila_Llena;
import data.exceptions.Pila_Vacia;
import data.interfaces.I_Pila;

public class Pila_Estatica<T> extends Pila_Generica implements I_Pila<T> {
    /* ATRIBUTOS */
    private T[] elements;   // Los elementos que guardo ( array de N posiciones)

    /* CONSTRUCTOR */
    @SuppressWarnings("unchecked")
    public Pila_Estatica ( int mida ) {
        super(mida);
        this.elements = ( T[] ) new Object[ mida ]; 
    }

    // Metodo que APILA un elemento en la cima de la pila
    public void apilar ( T elem ) throws Pila_Llena {
        if ( this.esLlena() )
            throw new Pila_Llena();

        this.elements[ super.numElems() ] = elem;
        super.incNumElems();
    }

    // Metodo que DESAPILA elemento en la cima de la pila
    public void desapilar ( ) throws Pila_Vacia {
        if ( this.esVacia() )
            throw new Pila_Vacia();

        super.decNumElems();
    }

    // Metodo que devuelve el elemento que ESTA EN LA CIMA
    public T cima () throws Pila_Vacia {
        if ( this.esVacia() )
            throw new Pila_Vacia(); 

        return this.elements[ super.numElems() - 1 ];
    }
}
