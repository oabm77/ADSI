/*
 * Hacer un algoritmo que imprima el costo de una llamada telefónica, 
 * capturando la duración de la llamada en minutos y conociendo lo siguiente:
 *
 * Toda llamada que dure tres minutos o menos tiene un costo de $200.
 * Cada minuto adicional cuesta  $30.
 */
package Ejercicio8;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Omar Augusto Bautista Mora
 */
public class Ejercicio8 {

    public static void main(String[] args) {
        // Definición de variables
        int duracionLlamada, costoLlamada, tiempoMinimoBase,
                costoMinimo, minutoAdicional;
        String respuesta;

        // Inicializar variables
        costoMinimo = 200;
        tiempoMinimoBase = 3;
        minutoAdicional = 30;
        respuesta = "";

        // Proceso de entrada
        try {
            duracionLlamada = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Ingrese la duracion de la llamada en minutos:",
                    "Calculadora de Costo de Llamada Telefonica",
                    JOptionPane.QUESTION_MESSAGE));

            // Proceso de cálculos y validaciones
            if (duracionLlamada <= tiempoMinimoBase) {
                costoLlamada = costoMinimo;
            } else {
                costoLlamada = costoMinimo + (duracionLlamada - tiempoMinimoBase) * minutoAdicional;
            }

            respuesta += "La llamada de " + duracionLlamada
                    + " minutos, tiene un costo de $" + costoLlamada;

            // Proceso de Salida
            System.out.println("Working Directory = "
                    + System.getProperty("user.dir"));
            ImageIcon icon = new ImageIcon(".//src//Ejercicio8//telephone-icon.png");
            JOptionPane.showMessageDialog(null, respuesta, "Costo de llamada", JOptionPane.INFORMATION_MESSAGE, icon);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Error: Ingrese sólo valores numéricos\n" + e,
                    "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
