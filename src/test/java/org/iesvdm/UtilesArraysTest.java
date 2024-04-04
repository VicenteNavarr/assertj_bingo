package org.iesvdm;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.Assertions.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;




public class UtilesArraysTest {

    @Test
    void test1() {

        assertThat(1 == 1).isTrue();
    }


    @Test
    void limpiarTest() {




        //Do
         int [] nuevo = UtilesArrays.limpiar();

        //Then

        assertThat(nuevo.length).isEqualTo(0);
    }


    @Test
    void rellenarTest() {

        int[] array = new int[6];
        int numeroElementos=10;



        //Do
        int [] rellenado = UtilesArrays.rellenar(array, numeroElementos);

        //Then

        //Comprobamos que rellena solo con ceros
        assertThat(rellenado).containsOnly(0);
        //Comprobamos que la longitud es correcta
        assertThat(array.length).isEqualTo(6);


    }

    @Test
    void rellenarTest2() {


        int[] array = new int[6];
        int valor = 3;
        int numeroElementos = 10;


        //Do
        int[] rellenado = UtilesArrays.rellenar(array, numeroElementos, valor);

        //Then
        for (int i = 0; i < numeroElementos; i++)
        {
            //Comprobamos que rellena con valor
            assertThat(rellenado[i]).isEqualTo(valor);
        }

    }


    @Test
    void insertarAlFinalTest1() {


        int[] array = new int[6];
        int elemento = 3;


        //Do
        int[] nuevoArray = UtilesArrays.insertarAlFinal(array, elemento);

        //Then

        //verificamos que la longitud del array es+1

        assertThat(nuevoArray).hasSize(array.length + 1);


        // Verificamos si el nuevo elemento se ha insertado al final
        assertThat(nuevoArray[nuevoArray.length - 1]).isEqualTo(elemento);


    }

    @Test
    void insertarAlPrincipioTest1() {


        int[] array = new int[6];
        int elemento = 3;


        //Do
        int[] nuevoArray = UtilesArrays.insertarAlPrincipio(array, elemento);

        //Then

        //verificamos que la longitud del array es+1

        assertThat(nuevoArray).hasSize(array.length + 1);


        // Verificamos si el nuevo elemento se ha insertado en la primera posición
        assertThat(nuevoArray[0]).isEqualTo(elemento);


    }

    @Test
    void insertarEnPosicionTest1() {


        int[] array = new int[6];
        int elemento = 3;
        int posicion=2;

        //Do
        int[] nuevoArray = UtilesArrays.insertarEnPosicion(array, elemento, posicion);

        //Then

        //verificamos que la longitud del array es +1

        assertThat(nuevoArray).hasSize(array.length+1);

        // Verificamos si el nuevo elemento se ha insertado en la  posición indicada
        assertThat(nuevoArray[posicion]).isEqualTo(elemento);
        // Verificamos si los elementos anteriores a la posición se mantienen en el mismo sitio
        for (int i = 0; i < posicion; i++) {
            assertThat(nuevoArray[i]).isEqualTo(array[i]);
        }
        // Verificamos sque los demñas elementos han adelantado una posición
        for (int i = posicion + 1; i < nuevoArray.length; i++) {
            assertThat(nuevoArray[i]).isEqualTo(array[i - 1]);
        }


    }

    @Test
    void insertarOrdenadoTest1() {


        // Do
        int[] array = {1, 3, 4, 5};
        int elemento = 2;

        // When
        int[] nuevoArray = UtilesArrays.insertarOrdenado(array, elemento);

        // Then

        //verificamos longitud
        assertThat(nuevoArray).hasSize(array.length+1);

        //verificamos ordenamiento
        assertThat(nuevoArray).containsExactly( 1, 2, 3, 4, 5);
    }


    @Test
    void eliminarUltimoTest1() {


        // Do
        int[] array = {1, 3, 4, 5};


        // When
        int[] nuevoArray = UtilesArrays.eliminarUltimo(array);

        // Then

        //verificamos longitud
        assertThat(nuevoArray).hasSize(array.length-1);

        //verificamos que elimina el último
        assertThat(nuevoArray).containsExactly(1,3,4);
    }


    @Test
    void eliminarPrimeroTest1() {


        // Do
        int[] array = {1, 3, 4, 5};


        // When
        int[] nuevoArray = UtilesArrays.eliminarPrimero(array);

        // Then

        //verificamos longitud
        assertThat(nuevoArray).hasSize(array.length-1);

        //verificamos que elimina el último
        assertThat(nuevoArray).containsExactly(3,4,5);
    }


    @Test
    void eliminarPosicionTest1() {


        int[] array = new int[6];
        int posicion=2;

        //Do
        int[] nuevoArray = UtilesArrays.eliminarPosicion(array, posicion);

        //Then

        //verificamos que la longitud del array es -1

        assertThat(nuevoArray).hasSize(array.length-1);


        // Verificamos si los elementos anteriores a la posición se mantienen en el mismo sitio
        for (int i = 0; i < posicion; i++) {
            assertThat(nuevoArray[i]).isEqualTo(array[i]);
        }
        // Verificamos sque los demñas elementos han atrasado una posición
        for (int i = posicion + 1; i < nuevoArray.length; i++) {
            assertThat(nuevoArray[i]).isEqualTo(array[i + 1]);
        }


    }


    @Test
    void eliminarTest1() {


        // Do
        int[] array = {1, 3, 4, 5};
        int elemento= 3;


        // When
        int[] nuevoArray = UtilesArrays.eliminar(array, elemento);

        // Then

        //verificamos longitud
        assertThat(nuevoArray).hasSize(array.length-1);

        // Verificamos si los elementos anteriores a la posición se mantienen en el mismo sitio

    }




    }
