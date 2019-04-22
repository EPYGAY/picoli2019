package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;


public class UI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_10;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	
	protected Comunicador comunicadorPoblacion,comunicadorEstadoLocal,comunicadorEstadoGlobal;
	private JPanel pnlPoblacion;
	private JPanel pnlEstadoLocal;
	private JPanel pnlEstadoGlobal;


	/**
	 * Create the frame.
	 */
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1340, 845);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][grow]", "[grow][grow]"));
		
		pnlPoblacion = new JPanel();
		pnlPoblacion.setBackground(new Color(244, 164, 96));
		contentPane.add(pnlPoblacion, "cell 0 0,grow");
		pnlPoblacion.setLayout(new MigLayout("", "[][][][]", "[][][][][][][][][][][][][][][][][][][][][][]"));
		
		JLabel lblPoblacion = new JLabel("POBLACION");
		lblPoblacion.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnlPoblacion.add(lblPoblacion, "cell 0 0");
		
		JLabel lblAbsolutos = new JLabel("Absolutos");
		lblAbsolutos.setFont(new Font("Tahoma", Font.ITALIC, 16));
		pnlPoblacion.add(lblAbsolutos, "cell 0 2");
		
		JLabel lblHabitantes = new JLabel("habitantes");
		lblHabitantes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(lblHabitantes, "cell 1 3,alignx trailing");
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(textField, "cell 3 3");
		textField.setColumns(10);
		
		JLabel lblMenores = new JLabel("menores");
		lblMenores.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(lblMenores, "cell 1 5,alignx trailing");
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setText("50");
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(textField_1, "cell 3 5");
		textField_1.setColumns(10);
		
		JLabel lblTrabjadores = new JLabel("trabjadores");
		lblTrabjadores.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(lblTrabjadores, "cell 1 7,alignx trailing");
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setText("100");
		textField_2.setEditable(false);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(textField_2, "cell 3 7");
		textField_2.setColumns(10);
		
		JLabel lblJubilados = new JLabel("jubilados");
		lblJubilados.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(lblJubilados, "cell 1 9,alignx trailing");
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setEditable(false);
		textField_3.setText("30");
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(textField_3, "cell 3 9");
		textField_3.setColumns(10);
		
		JLabel lblRelativos = new JLabel("Relativos");
		lblRelativos.setFont(new Font("Tahoma", Font.ITALIC, 16));
		pnlPoblacion.add(lblRelativos, "cell 0 12");
		
		JLabel lblNacimientos = new JLabel("nacimientos");
		lblNacimientos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(lblNacimientos, "cell 1 14,alignx trailing");
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setEditable(false);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(textField_4, "cell 3 14");
		textField_4.setColumns(10);
		
		JLabel lblFallecimientos = new JLabel("fallecimientos");
		lblFallecimientos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(lblFallecimientos, "cell 1 16,alignx trailing");
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setEditable(false);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(textField_5, "cell 3 16");
		textField_5.setColumns(10);
		
		JLabel lblJubilaciones = new JLabel("jubilaciones");
		lblJubilaciones.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(lblJubilaciones, "cell 1 18,alignx trailing");
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setEditable(false);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(textField_6, "cell 3 18");
		textField_6.setColumns(10);
		
		JLabel lblNuevosTrabjadores = new JLabel("nuevos trabjadores");
		lblNuevosTrabjadores.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(lblNuevosTrabjadores, "cell 1 20,alignx trailing");
		
		textField_7 = new JTextField();
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setEditable(false);
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(textField_7, "cell 3 20");
		textField_7.setColumns(10);
		
		JLabel label = new JLabel("");
		pnlPoblacion.add(label, "cell 2 21");
		
		JPanel pnlBotonera = new JPanel();
		contentPane.add(pnlBotonera, "cell 1 0,grow");
		pnlBotonera.setLayout(new BorderLayout(0, 0));
		
		JLabel lblControlEstado = new JLabel("Control Estado");
		lblControlEstado.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblControlEstado.setHorizontalAlignment(SwingConstants.CENTER);
		pnlBotonera.add(lblControlEstado, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		pnlBotonera.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton = new JButton("Incrementa Porcentaje Produccion");
		panel.add(btnNewButton);
		btnNewButton.setActionCommand("");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		JButton btnNewButton_2 = new JButton("Pasar un periodo");
		panel.add(btnNewButton_2);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNewButton_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton btnNewButton_1 = new JButton("Decrementa porcentaje produccion");
		panel.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		pnlEstadoLocal = new JPanel();
		pnlEstadoLocal.setBackground(new Color(143, 188, 143));
		contentPane.add(pnlEstadoLocal, "cell 0 1,grow");
		pnlEstadoLocal.setLayout(new MigLayout("", "[][][][][][]", "[][][][][][][][][][][][]"));
		
		JLabel lblEstadoLocal = new JLabel("ESTADO LOCAL");
		lblEstadoLocal.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnlEstadoLocal.add(lblEstadoLocal, "cell 0 0");
		
		JLabel lblFabricas = new JLabel("Fabricas");
		lblFabricas.setFont(new Font("Tahoma", Font.ITALIC, 16));
		pnlEstadoLocal.add(lblFabricas, "cell 0 2");
		
		JLabel lblOcupacion = new JLabel("% ocupacion");
		lblOcupacion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlEstadoLocal.add(lblOcupacion, "cell 5 2");
		
		JLabel lblGrandes = new JLabel("grandes");
		lblGrandes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlEstadoLocal.add(lblGrandes, "cell 1 5,alignx trailing");
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlEstadoLocal.add(textField_10, "cell 3 5");
		textField_10.setColumns(10);
		
		pnlEstadoGlobal = new JPanel();
		pnlEstadoGlobal.setBackground(new Color(245, 222, 179));
		contentPane.add(pnlEstadoGlobal, "cell 1 1,grow");
		pnlEstadoGlobal.setLayout(new MigLayout("", "[][][][]", "[][][][][][][][][][][][][][][][][][]"));
		
		JLabel lblEstadoGlobal = new JLabel("ESTADO GLOBAL");
		lblEstadoGlobal.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnlEstadoGlobal.add(lblEstadoGlobal, "cell 0 0");
		
		JLabel lblAbsolutas = new JLabel("Absolutas");
		lblAbsolutas.setFont(new Font("Tahoma", Font.ITALIC, 16));
		pnlEstadoGlobal.add(lblAbsolutas, "cell 0 1");
		
		JLabel lblNewLabel = new JLabel("Demanda Anual");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlEstadoGlobal.add(lblNewLabel, "cell 1 3,alignx trailing,aligny center");
		
		textField_14 = new JTextField();
		textField_14.setHorizontalAlignment(SwingConstants.CENTER);
		textField_14.setEditable(false);
		textField_14.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlEstadoGlobal.add(textField_14, "cell 3 3,growx");
		textField_14.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Produccion anual");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlEstadoGlobal.add(lblNewLabel_1, "cell 1 5");
		
		textField_15 = new JTextField();
		textField_15.setHorizontalAlignment(SwingConstants.CENTER);
		textField_15.setEditable(false);
		textField_15.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlEstadoGlobal.add(textField_15, "cell 3 5,growx");
		textField_15.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Capital Estatal");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlEstadoGlobal.add(lblNewLabel_2, "cell 1 7,alignx trailing,aligny top");
		
		textField_16 = new JTextField();
		textField_16.setHorizontalAlignment(SwingConstants.CENTER);
		textField_16.setEditable(false);
		textField_16.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlEstadoGlobal.add(textField_16, "cell 3 7,growx");
		textField_16.setColumns(10);
		
		JLabel lblPorcentuales = new JLabel("Porcentuales");
		lblPorcentuales.setFont(new Font("Tahoma", Font.ITALIC, 16));
		pnlEstadoGlobal.add(lblPorcentuales, "cell 0 10");
		
		JLabel lblNewLabel_3 = new JLabel("Crecimiento Anual");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlEstadoGlobal.add(lblNewLabel_3, "cell 1 13,alignx trailing");
		
		textField_17 = new JTextField();
		textField_17.setHorizontalAlignment(SwingConstants.CENTER);
		textField_17.setEditable(false);
		textField_17.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlEstadoGlobal.add(textField_17, "cell 3 13,growx");
		textField_17.setColumns(10);
		
		JLabel label_1 = new JLabel(" ");
		pnlEstadoGlobal.add(label_1, "cell 1 17");
		comunicadorPoblacion=crearComunicador(pnlPoblacion);
		comunicadorEstadoLocal=crearComunicador(pnlEstadoLocal);
		
		textField_13 = new JTextField();
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		textField_13.setEditable(false);
		textField_13.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlEstadoLocal.add(textField_13, "cell 5 5");
		textField_13.setColumns(10);
		comunicadorEstadoGlobal=crearComunicador(pnlEstadoGlobal);
	}


	private Comunicador crearComunicador(JPanel jPanel) {
		Component[] components = jPanel.getComponents();
		Comunicador retorno=new Comunicador();
		for (int i = 0; i < components.length; i++) {
			if (components[i] instanceof JTextField) {
			retorno.addControl((JTextField)components[i]);	
			}
		}
		return retorno;
	}

}
