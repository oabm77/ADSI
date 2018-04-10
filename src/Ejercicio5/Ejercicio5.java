/*
 * Desarrollar un algoritmo que calcule el salario neto que debe recibir un vendedor de un almacén.
 * Se debe tener en cuenta si tiene derecho o no al auxilio de transporte.
 * Para el desarrollo del ejercicio tenga en cuenta las siguientes fórmulas:
 *
 * Sueldo devengado = salario básico * dias laborados / 30
 *
 * Días laborados = debe ser entre 1 y 30.
 * 
 * Auxilio de transporte: lo reciben los empleados cuyo salario básico sea menor o igual a dos salarios mínimos legales vigentes.
 *
 * Salario Mínimo Legal Vigente(2013): 589500
 *
 * Auxilio de transporte: 70500 * días laborados / 30 (año 2013 en Colombia)
 *
 * Comisión de ventas: En la empresa se tiene estipulado dar una comisión de ventas del 2% sobre las ventas del mes de cada vendedor.
 *
 * Total devengado: sueldo devengado +  comisión de ventas
 *
 * Total deducciones = descuentos por prestamos
 *
 * Salario Neto = Total devengado - Total deducciones
 *
 * Como resultado del ejercicio se debe imprimir en la pantalla lo siguiente:
 *
 * Cedula empleado: 		XXXXXXX
 * Nombre empleado: 		XXXXXXX
 * Salario Basico:		XXXXXXX
 * Auxilio de Transporte: 	XXXXXXX
 * Comision de ventas:		XXXXXXX
 * Prestamos:			XXXXXXX
 * Salario Neto a recibir:	XXXXXXX
 */
package Ejercicio5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Omar Augusto Bautista Mora
 */
public class Ejercicio5 extends JFrame{

    public static JTextField cedulaJTF, nombreJTF, sBasicoJTF, 
            ventasJTF, prestamoJTF, intPrestamoJTF, 
            cuotasPrestamoJTF;
    JLabel labelDiasLab;
    JSlider sliderDiasLab;
    JPanel j1, j2, j3, panelSiNo, panelUnido, panelBotones;
    JButton calculateBtn, exitBtn;
    public static JRadioButton si, no;
    ButtonGroup grupoSiNo;
    public static int diasLab;
    public static String resultado;

    public Ejercicio5() {
        j1 = new JPanel(new GridLayout(0, 2));
        j2 = new JPanel(new GridLayout(0, 2));
        j3 = new JPanel(new GridLayout(0, 2));

        j1.add(new JLabel("Cédula del empleado:"));
        cedulaJTF = new JTextField(10);
        j1.add(cedulaJTF);
        j1.add(new JLabel("Nombre del empleado:"));
        nombreJTF = new JTextField(20);
        j1.add(nombreJTF);
        j1.add(new JLabel("Salario Básico: $"));
        sBasicoJTF = new JTextField(10);
        j1.add(sBasicoJTF);        
        j1.add(new JLabel("Total de Ventas realizadas: $"));
        ventasJTF = new JTextField(10);
        j1.add(ventasJTF);
        diasLab = 0;
        labelDiasLab = new JLabel("Dias laborados: " + diasLab + " dias");
        j2.add(labelDiasLab);
        sliderDiasLab = new JSlider(JSlider.HORIZONTAL, 0, 30, 0);
        sliderDiasLab.setMajorTickSpacing(5);
        sliderDiasLab.setMinorTickSpacing(1);
        sliderDiasLab.setPaintLabels(true);
        sliderDiasLab.setPaintTicks(true);
        sliderDiasLab.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider valor = (JSlider) e.getSource();
                diasLab = valor.getValue();
                labelDiasLab.setText("Dias laborados: " + diasLab + " dias");
            }
        });
        j2.add(sliderDiasLab);
        panelSiNo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        si = new JRadioButton("Si");
        si.setActionCommand("Si");
        no = new JRadioButton("No");
        no.setActionCommand("No");
        si.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j3.setVisible(true);
            }
        });
        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j3.setVisible(false);
            }
        });
        grupoSiNo = new ButtonGroup();
        grupoSiNo.add(si);
        grupoSiNo.add(no);
        panelSiNo.add(si);
        panelSiNo.add(no);
        j2.add(new JLabel("¿Tiene algún prestamo?:"));
        j2.add(panelSiNo);
        j3.add(new JLabel("Total del prestamo: $"));
        prestamoJTF = new JTextField(10);
        j3.add(prestamoJTF);
        j3.add(new JLabel("Tasa de interés %:"));
        intPrestamoJTF = new JTextField(10);
        j3.add(intPrestamoJTF);
        j3.add(new JLabel("cuotas (meses):"));
        cuotasPrestamoJTF = new JTextField(10);
        j3.add(cuotasPrestamoJTF);
        panelUnido = new JPanel(new GridLayout(0,1));
        panelUnido.add(j2);
        panelUnido.add(j3);
        panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        calculateBtn = new JButton("Calcular");
        calculateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField[] jtf = 
                        (si.isSelected())?new JTextField[]{cedulaJTF, sBasicoJTF, ventasJTF, prestamoJTF, intPrestamoJTF, cuotasPrestamoJTF}
                        :new JTextField[]{cedulaJTF, sBasicoJTF, ventasJTF};
                if(!validateFields(jtf)) {
                    resultado = calculateResult();
                    JOptionPane.showMessageDialog(null, resultado, "Resultado Final", JOptionPane.INFORMATION_MESSAGE);
                } else{
                    JOptionPane.showMessageDialog(null, "Error: Algunos campos contienen valores incorrectos", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        exitBtn = new JButton("Salir");
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panelBotones.add(calculateBtn);
        panelBotones.add(exitBtn);
        add(BorderLayout.NORTH, j1);
        add(BorderLayout.CENTER, panelUnido);
        add(BorderLayout.SOUTH, panelBotones);
        j3.setVisible(false);
    }

    public static boolean validateFields(JTextField[] jtfs) {
        boolean error = false;
        for(JTextField jtf:jtfs) {
            Border border = nombreJTF.getBorder();
            try {
                double i = Double.parseDouble(jtf.getText());
            } catch (NumberFormatException ex) {
                border = BorderFactory.createLineBorder(Color.RED);
                error = true;
            } finally {
                jtf.setBorder(border);
            }
        }
        return error;
    }
    
    public static String calculateResult() {
        double smlv, sBasico, sDevenga, baseAuxTrans, 
                auxTrans, ventas, comVentas, tComision, cuotasPrestamo, 
                tDevenga, tDeducc, sNeto, prestamo, intPrestamo;
        
        // Inicializar variables        
	smlv = 589500;		// Salario Mínimo Legal Vigente(2013)
	baseAuxTrans = 70500;	// base para calcular Auxilio de transporte (año 2013 en Colombia)
	comVentas = 0.02;	// comisión de ventas estipulado por la empresa sobre las ventas del mes de cada vendedor
        tDeducc = 0;            // Si se realizó algún prestamo este valor afectará deducciones
        
        // cálculos
        sBasico = Double.parseDouble(sBasicoJTF.getText());
        ventas = Double.parseDouble(ventasJTF.getText());
        sDevenga = calcularSueldoDevengado(sBasico, diasLab); // Sueldo devengado
	auxTrans = calcularAuxilioTransporte(sBasico, smlv, baseAuxTrans, diasLab); // Auxilio de transporte
	tComision = calcularComisionVentas(ventas, comVentas);  // Comisión de ventas
	tDevenga = sDevenga + tComision;    // Total devengado
        if(si.isSelected()) {
            prestamo = Double.parseDouble(prestamoJTF.getText());
            intPrestamo = Double.parseDouble(intPrestamoJTF.getText());
            cuotasPrestamo = Double.parseDouble(cuotasPrestamoJTF.getText());
            tDeducc = calcularPrestamo(prestamo, intPrestamo, cuotasPrestamo);  // Total deducciones
        }
	sNeto = tDevenga - tDeducc;													// Salario Neto
        return  "Cedula empleado: "+ cedulaJTF.getText() + "\n" +
                "Nombre empleado: "+ nombreJTF.getText() + "\n" +
                "Salario Basico: $"+ sBasico + "\n" +
                "Auxilio de Transporte: $"+ auxTrans + "\n" +
                "Comision de ventas: $"+ tComision + "\n" +
                "Prestamos: $"+ tDeducc + "\n" +
                "Salario Neto a recibir: $"+ sNeto;
    }
    
    public static double calcularPrestamo(double prestamo, double interes, double cuotas) {
        return prestamo * (1 + interes / 100) / cuotas;
    }

    public static double calcularSueldoDevengado(double basico, int dias) {
        return basico * dias / 30;
    }

    public static double calcularAuxilioTransporte(double basico, double smlv, double base, int dias) {
        double resultado = 0;		// valor predeterminado
        if (basico <= smlv * 2) {
            resultado = base * dias / 30;
        }
        return resultado;
    }

    public static double calcularComisionVentas(double ventas, double comision) {
        double resultado = ventas * comision;
        return resultado;
    }

    public static void main(String[] args) {

        Ejercicio5 frame = new Ejercicio5();
        frame.setTitle("Calculador de Salario Neto para empleados");
        frame.setSize(640, 480);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);

    }
}