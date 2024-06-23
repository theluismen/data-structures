package data;

public abstract class Pila_Generica {
    /* ATRIBUTOS */
    private int nElem; // Numero de elementos guardados
    private int mida;

    public Pila_Generica ( int mida ) {
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
        this.nElem --;
    }
    
    // Metodo que INCREMENTA el numero de elementos
    public void incNumElems() {
        this.nElem ++;
    }
}
