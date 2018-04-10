/*
 * Desarrollar un algoritmo que lea un número N entero positivo de cualquier
 * número de dígitos, calcule la suma de sus dígitos y que imprima en pantalla
 * el número leído y la suma de sus dígitos.
 * Se requiere que en el desarrollo utilice la Estructura Cíclica Mientras.
 */

package Ejercicio4;

import javax.swing.JOptionPane;

/**
 *
 * @author Omar Augusto Bautista Mora
 */
public class Ejercicio4 {

    private static int sumaDigitos(int N) {
        int suma = 0;
        while(N > 0) {
            suma += N % 10;
            N /= 10;
        }
        return suma;
    }

    public static void main(String[] args) {
        try {
            int N = Integer.parseInt(
                    JOptionPane.showInputDialog(null,
                    "Introduzca número para calcular la suma de los digitos"));
            int suma = sumaDigitos(N);
            String respuesta = "N = " + N +
                    "\nSUMA = " + suma;
            JOptionPane.showMessageDialog(null,
                    respuesta,
                    "Suma de digitos del número",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Error: Ingrese sólo valores numéricos\n" + e,
                    "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
