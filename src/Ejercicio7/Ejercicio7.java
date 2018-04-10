/*
 * Desarrollar un algoritmo que permita calcular los siguientes datos de una fiesta:
 * ¿Cuántas personas asistieron a la fiesta?
 * ¿Cuántos hombres y cuántas mujeres?
 * Promedio de edades por sexo
 * La edad de la persona más joven que asistió
 *
 * Consideraciones:
 * No se permiten menores de edad a la fiesta.
 * Ingresar datos hasta que se ingrese una edad igual a cero.
 */
package Ejercicio7;

import javax.swing.JOptionPane;

/**
 *
 * @author Omar Augusto Bautista Mora
 */
public class Ejercicio7 {

    // Sección de funciones del programa
    public static String leerGenero() {
        String genero = JOptionPane.showInputDialog(null,
                "Ingresa persona a la fiesta\nHombre (M) - Mujer (F):",
                "Personas en la fiesta",
                JOptionPane.QUESTION_MESSAGE);
        String valores = "f, F, m, M";
        if (valores.contains(genero)) {
            return genero;
        } else {
            JOptionPane.showMessageDialog(null,
                    "Género erroneo",
                    "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return leerGenero();
        }
    }

    public static int leerEdad() {
        try {
            int edad = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Ingrese la edad:",
                    "Edad de la persona",
                    JOptionPane.QUESTION_MESSAGE));

            if (edad >= 18) {
                return edad;
            } else {
                JOptionPane.showMessageDialog(null,
                        "No se permiten menores de edad a la fiesta",
                        "¡Error!",
                        JOptionPane.ERROR_MESSAGE);
                return leerEdad();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Error: Ingrese sólo valores numéricos\n" + e,
                    "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
            return leerEdad();
        }
    }

    public static void main(String[] args) {
        // Definición de variables
        int edad, cantidadPersonas, hombres, mujeres, edadMasJoven, mayorEdad, continua;
        double promedioEdadHombres, promedioEdadMujeres;
        String genero, respuesta;

        // Inicializar variables
        mayorEdad = 18;
        cantidadPersonas = 0;
        hombres = 0;
        mujeres = 0;
        promedioEdadHombres = 0;
        promedioEdadMujeres = 0;
        respuesta = "";

// Proceso de entrada y validaciones
        genero = leerGenero();
        edad = leerEdad();
        edadMasJoven = edad;
        do {
            if (edad >= mayorEdad) {
                cantidadPersonas++;
                if (edad < edadMasJoven) {
                    edadMasJoven = edad;
                }
                String masculino = "M, m";
                if (masculino.contains(genero)) {
                    hombres++;
                    promedioEdadHombres += edad;
                } else {
                    mujeres++;
                    promedioEdadMujeres += edad;
                }
            }
            continua = JOptionPane.showConfirmDialog(null,
                    "Ingresa otra persona?",
                    "Agregar",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (continua == JOptionPane.YES_OPTION) {
                genero = leerGenero();
                edad = leerEdad();
            }
        } while (continua == JOptionPane.YES_OPTION);

// Proceso de cálculos
        if (cantidadPersonas > 0) {
            promedioEdadHombres /= hombres;
            promedioEdadMujeres /= mujeres;
        }

// Proceso de Salida
        respuesta += "Asistieron " + cantidadPersonas + " personas a la fiesta";
        respuesta += "\nHombres :" + hombres;
        respuesta += "\nMujeres :" + mujeres;
        if (hombres > 0) {
            respuesta += "\nEl promedio de edades de los hombres es :" + promedioEdadHombres;
        }
        if (mujeres > 0) {
            respuesta += "\nEl promedio de edades de las mujeres es :" + promedioEdadMujeres;
        }
        respuesta += "\nLa edad de la persona mas joven es: " + edadMasJoven;

        JOptionPane.showMessageDialog(null,
                respuesta,
                "Personas en la fiesta",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
