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

public class FrmAgregarAuto extends JFrame {

    private JPanel contentPane;
    private JTextField txtMatricula, txtMarca, txtPrecio, txtCilindrada, txtPromocion;
    private JCheckBox chkCilindrada;
    private JButton btnAgregarAuto, btnCalcular, btnLimpiar;
    private JTextArea textAreaAutos;
    private ListaAutos listaAutos;
  
    public FrmAgregarAuto() {
        listaAutos = new ListaAutos(); // Inicializar ListaAutos
        setTitle("Gestión de Autos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 450);
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
        btnLimpiar.setBounds(75, 139, 90, 25);
        panel1.add(btnLimpiar);

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
        chkCilindrada = new JCheckBox("¿Es un auto?");
        chkCilindrada.setBounds(10, 25, 100, 20);
        panel2.add(chkCilindrada);

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

        // JTextArea para mostrar la lista de autos
        textAreaAutos = new JTextArea();
        textAreaAutos.setEditable(false);
        JScrollPane scrollPaneAutos = new JScrollPane(textAreaAutos);
        scrollPaneAutos.setBounds(10, 210, 460, 130);
        contentPane.add(scrollPaneAutos);

        // Botón para agregar autos
        btnAgregarAuto = new JButton("Agregar Auto");
        btnAgregarAuto.setBounds(150, 350, 200, 30);
        contentPane.add(btnAgregarAuto);
    }

    private void iniciarManejadoresEventos() {
        // Acción del botón "Agregar Auto"
        btnAgregarAuto.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                agregarAuto();
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
        chkCilindrada.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtCilindrada.setEnabled(chkCilindrada.isSelected());
            }
        });
    }//fin iniciarManejadoresEventos

    // Método para agregar un auto a la lista y actualizar el JTextArea
    private void agregarAuto() {
    	if (!camposVacios()) {
	        
	        try {
	            String matricula = txtMatricula.getText();
	            String marca = txtMarca.getText();
	            double precio = Double.parseDouble(txtPrecio.getText());
	          //  int cilindrada = chkCilindrada.isSelected() ? Integer.parseInt(txtCilindrada.getText()) : 0;
	            int cilindrada;   
	            if (chkCilindrada.isSelected()) {  
	                cilindrada = Integer.parseInt(txtCilindrada.getText());  
	            } else {  
	                cilindrada = 0;  
	            }  
	            Auto a = new Auto(matricula, marca, precio, cilindrada);
	            listaAutos.agregar(a);
	            actualizarListaAutos(); // Actualizar el JTextArea
	            limpiarCampos(); // Limpiar los campos después de agregar
	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(this, "Error: Ingrese valores numéricos válidos en los campos de Precio y Cilindrada.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
	        }
        }
    }

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
        chkCilindrada.setSelected(false);
        txtCilindrada.setEnabled(false); // Deshabilita el campo de cilindrada al limpiar
    }

    // Método para actualizar el JTextArea con la lista de autos
    private void actualizarListaAutos() {
        textAreaAutos.setText(listaAutos.listarAutos());
    }
    
    //Chequea si hay algún campo vacío
    private boolean camposVacios() {
    	boolean vacio=false;
	    if (txtMatricula.getText().isEmpty() || txtMarca.getText().isEmpty() || txtPrecio.getText().isEmpty() ||
	            (chkCilindrada.isSelected() && txtCilindrada.getText().isEmpty())) {
	            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos para calcular la promoción.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
	            vacio=true;
	    } 
	    return vacio;
    }
}

