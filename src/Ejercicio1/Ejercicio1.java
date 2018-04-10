/*
 * Ejercicio 1
 * Una persona deposita hoy al Banco cierta cantidad de dinero,
 * donde le reconocen un interés del 2% mensual, capitalizado mensualmente.
 * ¿Cuál será el saldo al cabo de 5 años?
 */
package Ejercicio1;

import javax.swing.JOptionPane;

/**
 *
 * @author Omar Augusto Bautista Mora
 */
public class Ejercicio1 {

    public static void main(String[] args) {
        double interes = 0.02;  // interés del 2% mensual
        int anios = 5; // 5 años
        int meses = anios * 12; // número total de meses
        try {
            double valorPresente = Double.parseDouble(
                    JOptionPane.showInputDialog("Ingrese cantidad de dinero depositado"));
            double valorFuturo = valorPresente * Math.pow((1 + interes), meses);
            String respuesta = "Valor consignado: $" + valorPresente
                    + ", Valor futuro en 5 años: $" + String.format("%.2f", valorFuturo);
            JOptionPane.showMessageDialog(null,
                    respuesta,
                    "Saldo con intereses",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Error: Ingrese sólo valores numéricos\n" + e,
                    "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
