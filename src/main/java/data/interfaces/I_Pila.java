package data.interfaces;

import data.exceptions.Pila_Llena;
import data.exceptions.Pila_Vacia;

public interface I_Pila<T> {
    // Metodo que apila un elemento en la cima de la pila
    public void apilar ( T elem ) throws Pila_Llena;

    // Metodo que desapila elemento en la cima de la pila
    public void desapilar () throws Pila_Vacia;
    
    // Metodo que devuelve el elemento que esta en la cima
    public T cima () throws Pila_Vacia;

    // Metodo que devuelve el NUMERO de ELEMENTOS
    public int numElems ();

    // Metodo que devuelve si la Pila esta llena o no
    public boolean esLlena ();
    
    // Metodo que devuelve si la Pila esta vacia o no
    public boolean esVacia ();
}
