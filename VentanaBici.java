package paraEstudiantes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class VentanaBici extends JFrame{
	
	private JPanel pnlContenedor;
	private JLabel lblCodigo,lblLabel2; //*
	private JTextField txtCodigo;
	private JButton btnAceptar;	//*
	private JTextField txtMarca;
	private JTextField txtPrecio;

	public VentanaBici(){
	
		iniciarComponentes();
		iniciarManejadoresEventos();
   		
	}
		
	
	private void iniciarComponentes() {
		
		setTitle("Prueba Final 2020");
   		setSize(296,157);
		setResizable(true);
		pnlContenedor = new JPanel();
		getContentPane().add(pnlContenedor);
		lblCodigo = new JLabel("  Ingrese código:");
		lblCodigo.setBounds(32, 19, 81, 14);
		lblLabel2 = new JLabel();
		lblLabel2.setBounds(209, 16, 0, 0);
		txtCodigo = new JTextField(10);
		txtCodigo.setBounds(159, 16, 86, 20);
		pnlContenedor.setLayout(null);

		pnlContenedor.add(lblCodigo);
		pnlContenedor.add(txtCodigo);
		pnlContenedor.add(lblLabel2);	//*
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(174, 219, 71, 23);
		pnlContenedor.add(btnAceptar);
		
		JLabel lblMarca = new JLabel("  Ingrese marca:");
		lblMarca.setBounds(32, 50, 81, 14);
		pnlContenedor.add(lblMarca);
		
		txtMarca = new JTextField(10);
		txtMarca.setBounds(159, 47, 86, 20);
		pnlContenedor.add(txtMarca);
		
		JLabel lblPrecio = new JLabel("  Ingrese precio:");
		lblPrecio.setBounds(32, 78, 81, 14);
		pnlContenedor.add(lblPrecio);
		
		txtPrecio = new JTextField(10);
		txtPrecio.setBounds(159, 75, 86, 20);
		pnlContenedor.add(txtPrecio);
		
		}
	
	private void iniciarManejadoresEventos() {
		
		
	}
}