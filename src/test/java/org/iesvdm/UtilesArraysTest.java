package org.iesvdm;

import org.assertj.core.api.AbstractStringAssert;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Assertions.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;import static org.junit.jupiter.api.Assertions.*;




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

        // Verificamos si los elementos anteriores a la posición se mantienen en el mismo sitio se ha eliminado el elemento
        assertThat(nuevoArray).containsExactly(1,4,5);
    }


    @Test
    void ordenarTest1() {


        // Do
        int[] array = {1, 4, 3, 5};



        // When
        int[] nuevoArray = UtilesArrays.ordenar(array);

        // Then

        //verificamos lordenación
        assertThat(nuevoArray).isSorted();



    }


    @Test
    void desordenarTest1() {


        // Do
        int[] array = {1, 4, 3, 5};



        // When
        UtilesArrays.desordenar(array);

        // Then

        //verificamos lordenación
        assertThat(array).containsExactlyInAnyOrder(1, 4, 3, 5);



    }


    @Test
    void invertirTest1() {


        // Do
        int[] array = {1, 4, 3, 5};



        // When
         int [] invertido = UtilesArrays.invertir(array);

        // Then

        //verificamos lordenación
        assertThat(invertido).containsExactly(5,3,4,1);



    }


    @Test
    void imprimirTest1() {

        //Do
        int[] array = {1, 3, 4, 5};


        // When
        UtilesArrays.imprimir(array);

        //Then
        //No se me ha ocurrido otra cosa...tabulador
        assertThat(Arrays.toString(array)).isEqualTo("[1, 3, 4, 5]");

    }

    @Test
    void estaOrdenadoTest1() {

        // Do
        int[] array = {1, 3, 4, 5};



        // When
        boolean ordenado = UtilesArrays.estaOrdenado(array);

        // Then

            assertThat(ordenado).isTrue();

        }


    @Test
    void buscarTest1() {

        // Do
        int[] array = {1, 3, 4, 5};
        int elemento=3;



        // When
        int encontrado = UtilesArrays.buscar(array, elemento);

        // Then

        //verificamos que encuentra en posición
        assertThat(encontrado).isEqualTo(1);
    }


    @Test
    void partirPorTest1() {

        // Do
        int[] array = {1, 3, 4, 5, 6, 7, 8, 9, 10};
        int posInicio=0;
        int posCorte=3;



        // When
        int[] nuevoArray = UtilesArrays.partirPor(array, posInicio, posCorte);

        // Then
        //Verificamos tamaño nuevo array
        assertThat(nuevoArray.length).isEqualTo(posCorte-posInicio);

        // Verificamos control de posiciones correctas:
        if(posInicio<array.length && posCorte<array.length && posInicio<posCorte) {
            // Verificamos que llena con las posiciones a partir de la de inicio del array de origen
            for (int i = 0; i < nuevoArray.length; i++) {

                assertThat(nuevoArray[i]).isEqualTo(array[i + posInicio]);
            }
        }else{

            assertThat(nuevoArray).isEqualTo(array);


        }


    }

    @Test
    void sonIgualesTest1() { //He corregido el método!! Daba errores

        // Do
        int[] array = {1, 3, 4, 5};
        int[] array2 = {1, 3, 4, 5};




        // When
        boolean iguales = UtilesArrays.sonIguales(array, array2);

        // Then

        //Verificamos longitudes
        assertThat(array.length).isEqualTo(array2.length);

        //verificamos que son iguales
        assertThat(iguales).isTrue();
    }

    @Test
    void elementosIgualesTest1() { //He corregido el método!! Daba errores

        // Do
        int[] array = {1, 3, 4, 5};
        int[] array2 = {1, 3, 4, 5};
        int posicioAComparar=3;





        // When
        boolean iguales = UtilesArrays.elementosIguales(array, array2, posicioAComparar);

        // Then

        //Verificamos longitudes
        assertThat(array.length).isEqualTo(array2.length);

        //verificamos que los elementos de las posiciones son iguales
        assertThat(array[posicioAComparar]).isEqualTo(array2[posicioAComparar]);


    }

    @Test
    void concatenarArraysTest1() { //He corregido el método!! Daba errores

        // Do
        int[] array = {1, 3, 4, 5};
        int[] array2 = {1, 3, 4, 5};






        // When
        int [] nuevoArray = UtilesArrays.concatenarArrays(array, array2);

        // Then

        //Verificamos que la longitud del nuevo array es la suma de las longitudes de los otros dos
        assertThat(nuevoArray.length).isEqualTo(array2.length+array.length);

        //Verificamos que el arry se ha creado correctamente
        assertThat(nuevoArray).containsExactly(1, 3, 4, 5, 1, 3, 4, 5);

    }








}





