
package grafica;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import logica.Auto;
import logica.ListaAutos;
import logica.Vehiculo;

public class FrmAgregarAuto extends JFrame {

    private JPanel contentPane;
    private JTextField txtMatricula, txtMarca, txtPrecio, txtCilindrada, txtPromocion;
    private JCheckBox chkEsAuto;
    private JButton btnGuardar, btnCalcular, btnLimpiar;
    private ListaAutos listaAutos;
  
    public FrmAgregarAuto() {
        listaAutos = new ListaAutos(); // Inicializar ListaAutos
        setTitle("Gestión de Autos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 254);
        iniciarComponentes();
        iniciarManejadoresEventos();
    }

    private void iniciarComponentes() {
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Panel de Datos del Vehículo
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.LIGHT_GRAY);
        panel1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.WHITE, Color.GRAY),
                "Datos del vehículo", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
        panel1.setBounds(10, 10, 236, 190);
        contentPane.add(panel1);
        panel1.setLayout(null);

        JLabel lblMatricula = new JLabel("Matrícula:");
        lblMatricula.setBounds(10, 25, 80, 20);
        panel1.add(lblMatricula);

        txtMatricula = new JTextField();
        txtMatricula.setBounds(100, 25, 120, 20);
        panel1.add(txtMatricula);

        JLabel lblMarca = new JLabel("Marca:");
        lblMarca.setBounds(10, 55, 80, 20);
        panel1.add(lblMarca);

        txtMarca = new JTextField();
        txtMarca.setBounds(100, 55, 120, 20);
        panel1.add(txtMarca);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setBounds(10, 85, 80, 20);
        panel1.add(lblPrecio);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(100, 85, 120, 20);
        panel1.add(txtPrecio);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(20, 139, 90, 25);
        panel1.add(btnLimpiar);
        
                // Botón para agregar autos
                btnGuardar = new JButton("Guardar");
                btnGuardar.setBounds(120, 140, 97, 23);
                panel1.add(btnGuardar);

        // Panel de Datos del Auto
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.LIGHT_GRAY);
        panel2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.WHITE, Color.GRAY),
                "Datos del auto", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
        panel2.setBounds(256, 10, 213, 100);
        contentPane.add(panel2);
        panel2.setLayout(null);

        JLabel lblCilindrada = new JLabel("Cilindrada:");
        lblCilindrada.setBounds(10, 60, 80, 20);
        panel2.add(lblCilindrada);

        txtCilindrada = new JTextField();
        txtCilindrada.setBounds(100, 60, 100, 20);
        txtCilindrada.setEnabled(false); // Inicialmente deshabilitado
        panel2.add(txtCilindrada);

        // CheckBox para habilitar/deshabilitar el campo de cilindrada
        chkEsAuto = new JCheckBox("¿Es un auto?");
        chkEsAuto.setBounds(10, 25, 100, 20);
        panel2.add(chkEsAuto);

        // Panel de Promoción
        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.LIGHT_GRAY);
        panel3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.WHITE, Color.GRAY),
                "Cálculo de la promoción", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
        panel3.setBounds(256, 120, 213, 80);
        contentPane.add(panel3);
        panel3.setLayout(null);

        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(10, 30, 90, 25);
        panel3.add(btnCalcular);

        txtPromocion = new JTextField();
        txtPromocion.setEditable(false);
        txtPromocion.setBounds(110, 30, 90, 25);
        panel3.add(txtPromocion);
    }

    private void iniciarManejadoresEventos() {
         
    	 btnGuardar.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		Auto a;
                Vehiculo v;
         		try {
					String matricula = txtMatricula.getText();
					String marca = txtMarca.getText();
					double precio = Double.valueOf(txtPrecio.getText());
					if (chkEsAuto.isSelected()) {
						
						int cilindrada = Integer.valueOf(txtCilindrada.getText());
						a = new Auto(matricula, marca, precio, cilindrada);
						JOptionPane.showMessageDialog(null, a.toString());

					} else {
						v = new Vehiculo(matricula, marca, precio);
						JOptionPane.showMessageDialog(null, v.toString());

					}
				} catch (Exception ex) {
					txtPromocion.setText("Error");
					JOptionPane.showMessageDialog(null, ex);
				}
         	}
         });

        // Acción del botón "Calcular" para la promoción
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularPromocion();
            }
        });

        // Acción del botón "Limpiar"
        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });

        // Acción del JCheckBox para habilitar/deshabilitar el campo de cilindrada
        chkEsAuto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtCilindrada.setEnabled(chkEsAuto.isSelected());
            }
        });
    }//fin iniciarManejadoresEventos

   
    // Método para calcular la promoción y mostrar el precio con descuento
    private void calcularPromocion() {
        // Verificar si los campos requeridos están vacíos
        if (!camposVacios()) {
              
	        try {
	            String matricula = txtMatricula.getText();
	            String marca = txtMarca.getText();
	            double precio = Double.parseDouble(txtPrecio.getText());
	            int cilindrada = Integer.parseInt(txtCilindrada.getText());
	            
	            Auto auto = new Auto(matricula, marca, precio, cilindrada);
	            double precioConDescuento = auto.promocion();
	            txtPromocion.setText(String.valueOf(precioConDescuento));
	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(this, "Error: Ingrese valores numéricos válidos en los campos de Precio y Cilindrada para calcular la promoción.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
	        } 
       }
    }

    // Método para limpiar los campos de texto
    private void limpiarCampos() {
        txtMatricula.setText("");
        txtMarca.setText("");
        txtPrecio.setText("");
        txtCilindrada.setText("");
        txtPromocion.setText("");
        chkEsAuto.setSelected(false);
        txtCilindrada.setEnabled(false); // Deshabilita el campo de cilindrada al limpiar
    }

   
    //Chequea si hay algún campo vacío
    private boolean camposVacios() {
    	boolean vacio=false;
	    if (txtMatricula.getText().isEmpty() || txtMarca.getText().isEmpty() || txtPrecio.getText().isEmpty() ||
	            (chkEsAuto.isSelected() && txtCilindrada.getText().isEmpty())) {
	            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos para calcular la promoción.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
	            vacio=true;
	    } 
	    return vacio;
    }
}

