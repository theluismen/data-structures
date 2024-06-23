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
    public void cargarLineas( String archivo, Pila<Integer> pila ) throws Pila_Llena {
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
    void TestInsercion1_Estatica () {
        Pila<Integer> pila = new Pila<>(false, 10);
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
    void TestInsercion2_Estatica () {
        Pila<Integer> pila = new Pila<>(false, 10);
        try {
            cargarLineas("pila.txt", pila);
            assertEquals(7, pila.numElems() );
        } catch (Pila_Llena e) {
            fail();
        }
    }
    
    @Test 
    void TestInsercionBorrado1_Estatica () {
        Pila<Integer> pila = new Pila<>(false, 10);
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
    void TestConsulta1_Estatica () {
        Pila<Integer> pila = new Pila<>(false, 10);
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
    void TestConsulta2_Estatica () {
        Pila<Integer> pila = new Pila<>(false, 10);
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
    void TestConsulta3_Estatica () {
        Pila<Integer> pila = new Pila<>(false, 10);
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
    void TestEsVacia1_Estatica () {
        Pila<Integer> pila = new Pila<>(false, 6);
        assertTrue( pila.esVacia() );
    }
    
    @Test
    void TestEsVacia2_Estatica () {
        Pila<Integer> pila = new Pila<>(false,6);
        try {
            pila.apilar(1); // Insertar
            pila.desapilar();    // Eliminar
            assertTrue( pila.esVacia() );
        } catch (Pila_Llena | Pila_Vacia ex) {
            fail();
        }
    }

    @Test
    void TestEsLlena1_Estatica () {
        Pila<Integer> pila = new Pila<>(false,6);
        assertFalse( pila.esLlena() );
    }

    @Test
    void TestEsLlena2_Estatica () {
        Pila<Integer> pila = new Pila<>(false,8);
        try {
            cargarLineas("pila.txt", pila);
            assertFalse( pila.esLlena() );
        } catch ( Pila_Llena e ) {
            fail();
        }
    }

    @Test
    void TestEsLlena3_Estatica () {
        Pila<Integer> pila = new Pila<>(false,7);
        try {
            cargarLineas("pila.txt", pila);
            assertTrue( pila.esLlena() );
        } catch ( Pila_Llena e ) {
            fail();
        }
    }
    
    @Test // Insercion manual
    void TestInsercion1_Dinamica () {
        Pila<Integer> pila = new Pila<>(true, 10);
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
    void TestInsercion2_Dinamica () {
        Pila<Integer> pila = new Pila<>(true, 10);
        try {
            cargarLineas("pila.txt", pila);
            assertEquals(7, pila.numElems() );
        } catch (Pila_Llena e) {
            fail();
        }
    }
    
    @Test 
    void TestInsercionBorrado1_Dinamica () {
        Pila<Integer> pila = new Pila<>(true, 10);
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
    void TestConsulta1_Dinamica () {
        Pila<Integer> pila = new Pila<>(true, 10);
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
    void TestConsulta2_Dinamica () {
        Pila<Integer> pila = new Pila<>(true, 10);
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
    void TestConsulta3_Dinamica () {
        Pila<Integer> pila = new Pila<>(true, 10);
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
    void TestEsVacia1_Dinamica () {
        Pila<Integer> pila = new Pila<>(true, 6);
        assertTrue( pila.esVacia() );
    }
    
    @Test
    void TestEsVacia2_Dinamica () {
        Pila<Integer> pila = new Pila<>(true,6);
        try {
            pila.apilar(1); // Insertar
            pila.desapilar();    // Eliminar
            assertTrue( pila.esVacia() );
        } catch (Pila_Llena | Pila_Vacia ex) {
            fail();
        }
    }

    @Test
    void TestEsLlena1_Dinamica () {
        Pila<Integer> pila = new Pila<>(true,6);
        assertFalse( pila.esLlena() );
    }

    @Test
    void TestEsLlena2_Dinamica () {
        Pila<Integer> pila = new Pila<>(true,8);
        try {
            cargarLineas("pila.txt", pila);
            assertFalse( pila.esLlena() );
        } catch ( Pila_Llena e ) {
            fail();
        }
    }

    @Test
    void TestEsLlena3_Dinamica () {
        Pila<Integer> pila = new Pila<>(true,7);
        try {
            cargarLineas("pila.txt", pila);
            assertTrue( pila.esLlena() );
        } catch ( Pila_Llena e ) {
            fail();
        }
    }

}
