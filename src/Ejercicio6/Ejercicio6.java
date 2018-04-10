/*
 * Hacer un algoritmo que imprima los primeros 20 términos de la siguiente serie:
 * 1, 3, 6, 10, 15, 21, 28,.......
 */
package Ejercicio6;

import javax.swing.JOptionPane;

/**
 *
 * @author Omar Augusto Bautista Mora
 */
public class Ejercicio6 {

    // funciones
    public static int[] calculaSerie(int[] serie, int i, int n) {
        if (i >= n) {
            return serie;
        }
        serie[i] = serie[i - 1] + i + 1;
        return calculaSerie(serie, i + 1, n);
    }

    public static void main(String[] args) {
        // Definición de variables
        int cantidad, i;
        int[] serie = new int[50];
        String respuesta = "";

        // Inicializar variables
        serie[0] = 1;

        // Proceso de entrada
        do {
            try {
                do {
                    cantidad = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Ingrese la cantidad de terminos de la serie (entre 1 y 50):",
                            "Cálculo de serie",
                            JOptionPane.QUESTION_MESSAGE));
                } while (cantidad < 1 || cantidad > serie.length);
                // Proceso de cálculos

                serie = calculaSerie(serie, 1, cantidad);

                // Proceso de Salida
                for (int j = 0; j < cantidad; j++) {
                    respuesta += (j + 1 < cantidad) ? serie[j] + ", " : serie[j];
                    if(j>1 && j%10==0)
                        respuesta += "\n";
                }
                JOptionPane.showMessageDialog(null,
                        "La serie es:\n" + respuesta,
                        "Serie",
                        JOptionPane.INFORMATION_MESSAGE);
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Error: Ingrese sólo valores numéricos\n" + e,
                        "¡Error!",
                        JOptionPane.ERROR_MESSAGE);
            }
        } while (true);
    }
}
