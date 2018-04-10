/*
 * Una frutería ofrece las manzanas a $4.200 el kilo,
 * con un descuento de acuerdo a la siguiente tabla:
 *
 * NUMERO DE KILOS      |  % DE DESCUENTO
 * 0 - 2                |   0%
 * 2,01 - 5             |   10%
 * 5,01 - 10            |   15%
 * 10.01 EN ADELANTE    |   20%
 * Desarrollar un algoritmo que le permita a la frutería y al cliente
 * conocer cuánto pagará un cliente que compre manzanas.
 */
package Ejercicio2;

import javax.swing.JOptionPane;

/**
 *
 * @author Omar Augusto Bautista Mora
 */
public class Ejercicio2 {

    // función que calcula el porcentaje de descuento a aplicar
    public static double calculaDescuento(double kilos) {
        if (kilos >= 2.01 && kilos <= 5) {
            return 0.1;
        } else if (kilos >= 5.01 && kilos <= 10) {
            return 0.15;
        } else if (kilos >= 10.01) {
            return 0.2;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        final double valorKilo = 4200;
        try {
            double kilos = Double.parseDouble(
                    JOptionPane.showInputDialog(null,
                    "¿Cuántos kilos de manzanas va a comprar?"));
            double valor = valorKilo * kilos;
            double descuento = valor * calculaDescuento(kilos);
            double valorAPagar = valor - descuento;
            String respuesta = "La compra de " + kilos + " kilos\ntiene un valor de $"
                    + valor + "\npero usted tiene un descuento por valor de $"
                    + descuento + "\npor lo tanto el valor a pagar es: $" + valorAPagar;
            JOptionPane.showMessageDialog(null,
                    respuesta,
                    "Valor a pagar",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Error: Ingrese sólo valores numéricos\n" + e,
                    "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
