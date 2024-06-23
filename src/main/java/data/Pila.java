package data;

import data.exceptions.Pila_Llena;
import data.exceptions.Pila_Vacia;
import data.interfaces.I_Pila;

public class Pila<T> implements I_Pila<T> {
    /* ATRIBUTOS */
    private I_Pila<T> pila;

    /* CONSTRUCTOR */
    public Pila ( boolean tipo, int mida ) {
        if ( tipo == false ) {
            this.pila = new Pila_Estatica<>( mida );
        } else {

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
