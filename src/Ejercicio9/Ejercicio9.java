/*
 * Un grupo de 10 estudiantes presentan un exámen de física. 
 * Hacer un algoritmo que lea por cada estudiante la calificación obtenida. 
 * Al finalizar calcule e imprima:
 *
 * La cantidad de estudiantes que obtuvieron una calificación menor a 50.
 * La cantidad de estudiantes que obtuvieron una calificación de 50 o más pero menor que 70.
 * La cantidad de estudiantes que obtuvieron una calificación de 70 o más pero menor que 80.
 * La cantidad de estudiantes que obtuvieron una calificación de 80 o más.
 *
 * La calificación obtenida en el exámen de física debe ser entre 1 y 100.
 */
package Ejercicio9;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Omar Augusto Bautista Mora
 */
public class Ejercicio9 {

    // Sección de funciones del programa
    public static int validaNota(int nota) {
        int rango;
        if (nota < 50) {
            rango = 0;
        } else if (nota < 70) {
            rango = 1;
        } else if (nota < 80) {
            rango = 2;
        } else {
            rango = 3;
        }

        return rango;
    }

    public static void leeNotas(int cantidad, int[] rangos) {
        int contador, nota, rango;
        contador = 1;
        while (contador <= cantidad) {
            try {
                nota = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Ingrese Nota #" + contador + ": ",
                        "Notas",
                        JOptionPane.QUESTION_MESSAGE + JOptionPane.OK_OPTION));
                if ((nota >= 1) && (nota <= 100)) {
                    rango = validaNota(nota);
                    rangos[rango] = rangos[rango] + 1;
                    contador = contador + 1;
                } else {
                    JOptionPane.showMessageDialog(null,
                            "¡Error, la nota debe ser entre 1 y 100!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Error: Ingrese sólo valores numéricos\n" + e,
                        "¡Error!",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        // Definición de variables
        int i;
        int[] rangos = new int[4];
        String respuesta;

        // Inicializar variables
        for (i = 0; i < rangos.length; i++) {
            rangos[i] = 0;
        }
        respuesta = "";

        // Proceso de entrada
        leeNotas(rangos.length, rangos);

        // Proceso de Salida
        respuesta += "Calificacion\t\t\tCantidad de estudiantes"
                + "\nmenor a 50:\t\t\t\t" + rangos[0]
                + "\nde 50 o mas pero menor que 70:\t\t" + rangos[1]
                + "\nde 70 o mas pero menor que 80:\t\t" + rangos[2]
                + "\nde 80 o mas:\t\t\t\t" + rangos[3];
        
        JOptionPane.showMessageDialog(null, 
                new JTextArea(respuesta), 
                "Resultados Calificaciones", 
                JOptionPane.INFORMATION_MESSAGE);
    }

}
