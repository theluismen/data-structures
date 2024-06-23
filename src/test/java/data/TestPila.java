package data;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import data.exceptions.Pila_Llena;
import data.exceptions.Pila_Vacia;

class TestPila {
    // Metodo que carga las lineas de un fichero a la pila recibida
    public void cargarLineas( String archivo, Pila_Estatica<Integer> pila ) throws Pila_Llena {
        BufferedReader br;
        String linea;

        try {
            br    = new BufferedReader( new FileReader( archivo ) );
            linea = br.readLine();
            while ( linea != null ) {
                pila.apilar( Integer.parseInt(linea) );
                linea = br.readLine();
            }
            br.close();
        } catch ( IOException | NumberFormatException ex ) {
            ex.printStackTrace();
        }
    }

    @Test // Insercion manual
    void TestInsercion1 () {
        Pila_Estatica<Integer> pila = new Pila_Estatica<>(10);
        try {
            pila.apilar(1); // Instertar 5 elementos
            pila.apilar(2);
            pila.apilar(3);
            pila.apilar(4);
            pila.apilar(5);
            assertEquals(5, pila.numElems() );
        } catch ( Pila_Llena ex ) {
            fail();
        }
    }
     
    @Test // Insercion desde archivo
    void TestInsercion2 () {
        Pila_Estatica<Integer> pila = new Pila_Estatica<>(10);
        try {
            cargarLineas("pila.txt", pila);
            assertEquals(7, pila.numElems() );
        } catch (Pila_Llena e) {
            fail();
        }
    }
    
    @Test 
    void TestInsercionBorrado1 () {
        Pila_Estatica<Integer> pila = new Pila_Estatica<>(10);
        try {
            pila.apilar(1); // Instertar 5 elementos
            pila.apilar(2);
            pila.apilar(3);
            pila.apilar(4);
            pila.apilar(5);
            pila.desapilar();
            assertEquals(4, pila.numElems() );
        } catch ( Pila_Llena | Pila_Vacia ex ) {
            fail();
        }
    }

    @Test
    void TestConsulta1() {
        Pila_Estatica<Integer> pila = new Pila_Estatica<>(10);
        try {
            pila.apilar(1); // Instertar 3 elementos
            pila.apilar(2);
            pila.apilar(3);
            assertEquals(3, pila.cima());
        } catch (Pila_Llena | Pila_Vacia ex) {
            fail();
        }
    }

    @Test
    void TestConsulta2() {
        Pila_Estatica<Integer> pila = new Pila_Estatica<>(10);
        try {
            pila.apilar(1); // Instertar 4 elementos
            pila.apilar(2);
            pila.apilar(3);
            pila.apilar(4);
            pila.desapilar();
            assertEquals(3, pila.cima());
        } catch (Pila_Llena | Pila_Vacia ex) {
            fail();
        }
    }

    @Test
    void TestConsulta3() {
        Pila_Estatica<Integer> pila = new Pila_Estatica<>(10);
        try {
            pila.apilar(1); 
            pila.apilar(2);
            pila.apilar(3);
            pila.apilar(4);
            pila.desapilar();
            assertEquals(3, pila.cima());
        } catch (Pila_Llena | Pila_Vacia ex) {
            fail();
        }
    }
    
    @Test
    void TestEsVacia1 () {
        Pila_Estatica<Integer> pila = new Pila_Estatica<>(6);
        assertTrue( pila.esVacia() );
    }
    
    @Test
    void TestEsVacia2 () {
        Pila_Estatica<Integer> pila = new Pila_Estatica<>(6);
        try {
            pila.apilar(1); // Insertar
            pila.desapilar();    // Eliminar
            assertTrue( pila.esVacia() );
        } catch (Pila_Llena | Pila_Vacia ex) {
            fail();
        }
    }

    @Test
    void TestEsLlena1 () {
        Pila_Estatica<Integer> pila = new Pila_Estatica<>(6);
        assertFalse( pila.esLlena() );
    }

    @Test
    void TestEsLlena2() {
        Pila_Estatica<Integer> pila = new Pila_Estatica<>(8);
        try {
            cargarLineas("pila.txt", pila);
            assertFalse( pila.esLlena() );
        } catch ( Pila_Llena e ) {
            fail();
        }
    }

    @Test
    void TestEsLlena3() {
        Pila_Estatica<Integer> pila = new Pila_Estatica<>(7);
        try {
            cargarLineas("pila.txt", pila);
            assertTrue( pila.esLlena() );
        } catch ( Pila_Llena e ) {
            fail();
        }
    }

}
