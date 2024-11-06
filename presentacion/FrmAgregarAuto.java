package grafica;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class FrmAgregarAuto extends JFrame {

	private JPanel contentPane;
	private JTextField txtMatricula;
	private JTextField txtCuotaNeta;
	private JButton btnCalcular;
	private JButton btnLimpiar;
	private JButton btnGuardar;
	private JTextField txtSaldoCuota;


	public FrmAgregarAuto() {
		setBounds(10, 10, 495, 227);
		setTitle("Agregar Autos");
		iniciarComponentes();
		iniciarManejadoresEventos();

	}
	

	private void iniciarComponentes() {
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.LIGHT_GRAY);
		panel1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos del ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel1.setBounds(10, 11, 236, 110);
		contentPane.add(panel1);
		panel1.setLayout(null);

		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(10, 30, 96, 14);
		panel1.add(lblMatricula);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(10, 55, 96, 14);
		panel1.add(lblMarca);

		txtMatricula = new JTextField();
		txtMatricula.setBounds(116, 27, 110, 20);
		panel1.add(txtMatricula);
		txtMatricula.setColumns(10);

		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.LIGHT_GRAY);
		panel2.setBorder(
				new TitledBorder(null, "Calculo de la cuota neta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel2.setBounds(256, 115, 213, 58);
		contentPane.add(panel2);
		panel2.setLayout(null);

		txtCuotaNeta = new JTextField();
		txtCuotaNeta.setEditable(false);
		txtCuotaNeta.setBounds(117, 25, 86, 20);
		panel2.add(txtCuotaNeta);
		txtCuotaNeta.setColumns(10);

		btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(10, 24, 89, 23);
		panel2.add(btnCalcular);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(10, 150, 89, 23);
		contentPane.add(btnLimpiar);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(123, 150, 89, 23);
		contentPane.add(btnGuardar);

		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(192, 192, 192));
		panel3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos del auto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel3.setBounds(259, 11, 210, 93);
		contentPane.add(panel3);
		panel3.setLayout(null);

		JLabel lblSaldoCuota = new JLabel("Saldo Cuota:");
		lblSaldoCuota.setBounds(6, 53, 97, 14);
		panel3.add(lblSaldoCuota);

		txtSaldoCuota = new JTextField();
		txtSaldoCuota.setBounds(113, 51, 86, 20);
		panel3.add(txtSaldoCuota);
		txtSaldoCuota.setColumns(10);
	}

	private void iniciarManejadoresEventos() {
		
		
	}


}
