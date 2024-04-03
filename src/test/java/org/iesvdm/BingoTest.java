package org.iesvdm;


import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class BingoTest {


    void test1() {

        assertThat(1 == 1).isTrue();
    }


    @Test
    void rellenarNumerosCartonTest1() {

        //when
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

        //for (int[] col: carton)
        //System.out.println(Arrays.toString(col));

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

}
