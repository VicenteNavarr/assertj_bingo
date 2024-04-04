package org.iesvdm;


import org.assertj.core.api.Assertions.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.iesvdm.Bingo.buscarValorRepetido;

public class BingoTest {


    void test1() {

        assertThat(1 == 1).isTrue();
    }


    @Test
    void testVerificacionNoVacio() {

        //when
        int[] col0 = new int[3];
        int[] col1 = new int[3];
        int[] col2 = new int[3];
        int[] col3 = new int[3];
        int[] col4 = new int[3];
        int[] col5 = new int[3];
        int[] col6 = new int[3];
        int[] col7 = new int[3];
        int[] col8 = new int[3];
        int[][] carton = {col0, col1, col2, col3, col4, col5, col6, col7, col8};


        //Then

        //verificamos que se ha rellenado el array correctamente

        for (int i = 0; i < carton.length; i++) {
            // Si estamos en la primera columna, generamos un nuevo número aleatorio
            int aleatorio = (int) (Math.random() * 9 + 1);

            // Recorremos las 3 posiciones de cada columna
            for (int j = 0; j < carton[i].length; j++) {
                // Asignamos el número aleatorio solo si estamos en la primera columna
                if (i == 0) {
                    carton[i][j] = aleatorio;
                }


                assertThat(carton).isNotEmpty();
            }
        }
    }


    @Test
    void testVerificacionNumeroFilas() {
        //when
        int[] col0 = new int[3];
        int[] col1 = new int[3];
        int[] col2 = new int[3];
        int[] col3 = new int[3];
        int[] col4 = new int[3];
        int[] col5 = new int[3];
        int[] col6 = new int[3];
        int[] col7 = new int[3];
        int[] col8 = new int[3];
        int[][] carton = {col0, col1, col2, col3, col4, col5, col6, col7, col8};


        //Then


        for (int i = 0; i < carton.length; i++) {
            // Verificamos filas
            assertThat(carton[i].length).isEqualTo(3);


        }
    }


    @Test
    void rellenarNumerosCartonTest1() {

        //when
        int[] col0 = new int[3];
        int[] col1 = new int[3];
        int[] col2 = new int[3];
        int[] col3 = new int[3];
        int[] col4 = new int[3];
        int[] col5 = new int[3];
        int[] col6 = new int[3];
        int[] col7 = new int[3];
        int[] col8 = new int[3];
        int[][] carton = {col0, col1, col2, col3, col4, col5, col6, col7, col8};


        //Do
        Bingo.rellenarNumerosCarton(carton);

        //Then

        for (int i = 0; i < carton.length; i++) {

            for (int j = 0; j < carton[i].length; j++) {
                //verificamos que no hay numeros duplicados en j
                assertThat(carton[j]).doesNotHaveDuplicates();

                //Verificamos que el random genere del 1 al 99 correctamente
                assertThat(carton[i][j]).isBetween(1, 99);

            }
            //verificamos que no hay numeros duplicados en i
            assertThat(carton[i]).doesNotHaveDuplicates();

            //Verificamos ordenación creciente
            assertThat(carton[i]).isSorted();

        }


    }


    @Test
    void ponerBlancosTest1() {

        //when
        int[] col0 = new int[3];
        int[] col1 = new int[3];
        int[] col2 = new int[3];
        int[] col3 = new int[3];
        int[] col4 = new int[3];
        int[] col5 = new int[3];
        int[] col6 = new int[3];
        int[] col7 = new int[3];
        int[] col8 = new int[3];
        int[][] carton = {col0, col1, col2, col3, col4, col5, col6, col7, col8};


        //Do
        Bingo.ponerBlancos(carton);

        //Then

        //verificamos que se ha rellenado el array correctamente
        assertThat(carton).isNotEmpty();

        //Este bucle es paa recolocar el cartón en su forma normal
        for (int j = 0; j < carton[0].length; j++) {
            for (int i = 0; i < carton.length; i++) {
                System.out.printf((carton[i][j] == 0 ? " 0" : carton[i][j]) + " ");
            }
            System.out.println("");
        }


        //Aquí vamos a comprobar el número de blancos
        //En cada columna, mínimo 0 máximo 2
        //El el cartón 12 blancos
        //En cada fila, 4 blancos
        int contBcarton = 0;

        for (int[] col : carton) {
            int contBc = 0;

            for (int celda : col) {
                if (celda == -1) {
                    contBc++;
                    contBcarton++;
                }
            }
            //Comprobamos blancos en columna
            assertThat(contBc).isLessThan(3);
//

        }
        //Comprobamos blancos en cartón
        assertThat(contBcarton).isEqualTo(12);

        for (int j = 0; j < carton[0].length; j++) {
            int contFilas = 0;
            for (int i = 0; i < carton.length; i++) {
                if (carton[i][j] == -1) {
                    contFilas++;
                }
            }
            assertThat(contFilas).isEqualTo(4);

        }


    }

    @Test
    void buscarFilaTest1() {

        //when

        int[] col0 = new int[3];
        int[] col1 = new int[3];
        int[] col2 = new int[3];
        int[] col3 = new int[3];
        int[] col4 = new int[3];
        int[] col5 = new int[3];
        int[] col6 = new int[3];
        int[] col7 = new int[3];
        int[] col8 = new int[3];
        int[][] carton = {col0, col1, col2, col3, col4, col5, col6, col7, col8};
        int fila = 1;
        int pos = 2;

        //do
        boolean resultado = Bingo.buscarFila(carton, fila, pos);


        //then


        for (int j = 0; j < carton[0].length; j++) {

            for (int i = 0; i < carton.length; i++) {
                if (carton[i][j] == -1) {
                    // si hay -1, devuelve true..encontrado
                    assertThat(resultado).isTrue();
                }else{
                    // si tod es  0, el resultado tiene que ser falso..no encontrado
                    assertThat(resultado).isFalse();
                }
            }
        }
    }

    @Test
    void buscarColumnaTest1() {

        //when

        int[] col0 = new int[3];
        int[] col1 = new int[3];
        int[] col2 = new int[3];
        int[] col3 = new int[3];
        int[] col4 = new int[3];
        int[] col5 = new int[3];
        int[] col6 = new int[3];
        int[] col7 = new int[3];
        int[] col8 = new int[3];
        int[][] carton = {col0, col1, col2, col3, col4, col5, col6, col7, col8};

        int posicionAleatoria = 2;



        //do
        boolean resultado = Bingo.buscarColumna(carton, posicionAleatoria);

        //Then
        boolean esta2Veces = false;
        int contador = 0;

        for (int i = 0; i < carton[0].length; i++) // Recorre las 3 posiciones del array
        {
            if(carton[posicionAleatoria][i] == -1)
            {
                contador++;
            }
        }

        if(contador>=2) // Cambio condición en caso de que ya tenga dos -1
        {

            assertThat(resultado).isTrue();

        }else if (contador<2){

            assertThat(resultado).isFalse();

        }


    }

    @Test
    void buscarValorRepetidoTest1() {

        //when


        //declaro:
        int [] fila= new int [9];
        int elemento=(int)(Math.random()*99+1);


        //When
        boolean resultado = Bingo.buscarValorRepetido(fila, elemento);


        //Then

        // Recorro todo el array buscando el elemento
        for (int i = 0; i < fila.length; i++)
        {
            if(fila[i] == elemento)
            {
                //Si lo encuentra --> true
                assertThat(resultado).isTrue();
            }else{
                //Si no lo encuentra --> false
                assertThat(resultado).isFalse();


            }
        }





    }
























}