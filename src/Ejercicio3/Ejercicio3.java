/*
 * Dada la siguiente función:
 * Y = x^2 - 2x
 * Se requiere desarrollar un algoritmo que imprima en pantalla, para valores de x desde 1 a 10, lo siguiente:
 * a) La suma de todos los valores de Y.
 * b) Valores de múltiplos de 3.
 * c) Suma de los valores de Y múltiplos de 3.
 * d) Valores de Y cuyo último digito sea 5.
 * e) Suma de los valores de Y cuyo último digito es 5.
 */

package Ejercicio3;

import javax.swing.JOptionPane;

/**
 *
 * @author Omar Augusto Bautista Mora
 */
public class Ejercicio3 {
    public static void main(String[] args) {
        double sumaY = 0,
               sumaMultiplosDe3 = 0,
               sumaUltimoDigito5 = 0;
        String multiplosDe3 = "", ultimoDigito5 = "";
        for (int x = 1; x <= 10; x++) {
            double Y = Math.pow(x, 2) - 2*x; // ecuación Y = x^2 - 2x
            sumaY += Y; // La suma de todos los valores de Y.
            if(Y % 3 == 0) {
                multiplosDe3 += (multiplosDe3 == ""?Y:", "+Y); // Valores de múltiplos de 3
                sumaMultiplosDe3 += Y; // Suma de los valores de Y múltiplos de 3.
            }
            if(Y % 10 == 5) {
                ultimoDigito5 += (ultimoDigito5 == ""?Y: ", "+Y); // Valores de Y cuyo último digito sea 5.
                sumaUltimoDigito5 += Y; // Suma de los valores de Y cuyo último digito es 5.
            }
        }
        String respuesta = "Valores de x del 1 al 10" +
                "\na) La suma de todos los valores de Y: " + sumaY +
                "\nb) Valores de múltiplos de 3: " + multiplosDe3 +
                "\nc) Suma de los valores de Y múltiplos de 3: " + sumaMultiplosDe3 +
                "\nd) Valores de Y cuyo último digito sea 5: " + ultimoDigito5 +
                "\ne) Suma de los valores de Y cuyo último digito es 5: " + sumaUltimoDigito5;

        JOptionPane.showMessageDialog(null,
                respuesta,
                "Ecuación Y = x^2 - 2x",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
