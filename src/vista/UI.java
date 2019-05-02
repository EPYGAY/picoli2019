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

import net.miginfocom.swing.*;


public class UI extends JFrame {

	private JPanel contentPane;
	private JTextField txtHabitantes;
	private JTextField txtMenores;
	private JTextField txtTrabajadores;
	private JTextField txtJubilados;
	private JTextField txtNacimientos;
	private JTextField txtFallecimientos;
	private JTextField textField_6;
	private JTextField txtNuvosTrabjadores;
	private JTextField txtEmpresa;
	private JTextField txtOcupacion;
	private JTextField txtDemandaAnual;
	private JTextField txtProduccionAnual;
	private JTextField txtCapitalEstatal;
	private JTextField txtCrecimientoAnual;
	
	protected Comunicador comunicadorPoblacion,comunicadorEstadoLocal,comunicadorEstadoGlobal;
	private JPanel pnlPoblacion;
	private JPanel pnlEstadoLocal;
	private JPanel pnlEstadoGlobal;
	private JTextField txtDesempleados;


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
		pnlPoblacion.setLayout(new MigLayout("", "[][][][][grow]", "[][][][][][][][][][][][][][][][][][][][][][][][]"));
		
		JLabel lblPoblacion = new JLabel("POBLACION");
		lblPoblacion.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnlPoblacion.add(lblPoblacion, "cell 0 0");
		
		JLabel lblAbsolutos = new JLabel("Absolutos");
		lblAbsolutos.setFont(new Font("Tahoma", Font.ITALIC, 16));
		pnlPoblacion.add(lblAbsolutos, "cell 0 2");
		
		JLabel lblHabitantes = new JLabel("habitantes");
		lblHabitantes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(lblHabitantes, "cell 1 3,alignx trailing");
		
		txtHabitantes = new JTextField();
		txtHabitantes.setHorizontalAlignment(SwingConstants.CENTER);
		txtHabitantes.setEditable(false);
		txtHabitantes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(txtHabitantes, "cell 4 3");
		txtHabitantes.setColumns(10);
		
		JLabel lblMenores = new JLabel("menores");
		lblMenores.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(lblMenores, "cell 1 5,alignx trailing");
		
		txtMenores = new JTextField();
		txtMenores.setHorizontalAlignment(SwingConstants.CENTER);
		txtMenores.setEditable(false);
		txtMenores.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(txtMenores, "cell 4 5");
		txtMenores.setColumns(10);
		
		JLabel lblTrabjadores = new JLabel("trabajadores");
		lblTrabjadores.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(lblTrabjadores, "cell 1 7,alignx trailing");
		
		txtTrabajadores = new JTextField();
		txtTrabajadores.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrabajadores.setEditable(false);
		txtTrabajadores.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(txtTrabajadores, "cell 4 7");
		txtTrabajadores.setColumns(10);
		
		JLabel lblJubilados = new JLabel("jubilados");
		lblJubilados.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(lblJubilados, "cell 1 9,alignx trailing");
		
		txtJubilados = new JTextField();
		txtJubilados.setHorizontalAlignment(SwingConstants.CENTER);
		txtJubilados.setEditable(false);
		txtJubilados.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(txtJubilados, "cell 4 9");
		txtJubilados.setColumns(10);
		
		JLabel lblDesempleado = new JLabel("desempleados");
		lblDesempleado.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesempleado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(lblDesempleado, "cell 1 11,alignx right");
		
		txtDesempleados = new JTextField();
		txtDesempleados.setHorizontalAlignment(SwingConstants.CENTER);
		txtDesempleados.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDesempleados.setEditable(false);
		txtDesempleados.setColumns(10);
		pnlPoblacion.add(txtDesempleados, "cell 4 11,alignx left");
		
		JLabel label_2 = new JLabel("");
		pnlPoblacion.add(label_2, "cell 1 12");
		
		JLabel lblRelativos = new JLabel("Relativos");
		lblRelativos.setFont(new Font("Tahoma", Font.ITALIC, 16));
		pnlPoblacion.add(lblRelativos, "cell 0 14");
		
		JLabel lblNacimientos = new JLabel("nacimientos");
		lblNacimientos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(lblNacimientos, "cell 1 16,alignx trailing");
		
		txtNacimientos = new JTextField();
		txtNacimientos.setHorizontalAlignment(SwingConstants.CENTER);
		txtNacimientos.setEditable(false);
		txtNacimientos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(txtNacimientos, "cell 4 16");
		txtNacimientos.setColumns(10);
		
		JLabel lblFallecimientos = new JLabel("fallecimientos");
		lblFallecimientos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(lblFallecimientos, "cell 1 18,alignx trailing");
		
		txtFallecimientos = new JTextField();
		txtFallecimientos.setHorizontalAlignment(SwingConstants.CENTER);
		txtFallecimientos.setEditable(false);
		txtFallecimientos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(txtFallecimientos, "cell 4 18");
		txtFallecimientos.setColumns(10);
		
		JLabel lblJubilaciones = new JLabel("jubilaciones");
		lblJubilaciones.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(lblJubilaciones, "cell 1 20,alignx trailing");
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setEditable(false);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(textField_6, "cell 4 20");
		textField_6.setColumns(10);
		
		JLabel lblNuevosTrabjadores = new JLabel("nuevos trabjadores");
		lblNuevosTrabjadores.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(lblNuevosTrabjadores, "cell 1 22,alignx trailing");
		
		txtNuvosTrabjadores = new JTextField();
		txtNuvosTrabjadores.setHorizontalAlignment(SwingConstants.CENTER);
		txtNuvosTrabjadores.setEditable(false);
		txtNuvosTrabjadores.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(txtNuvosTrabjadores, "cell 4 22");
		txtNuvosTrabjadores.setColumns(10);
		
		JLabel label = new JLabel("");
		pnlPoblacion.add(label, "cell 3 23");
		
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
		
		JButton btnIncrementarPorcentajeProduccion = new JButton("Incrementa Porcentaje Produccion");
		panel.add(btnIncrementarPorcentajeProduccion);
		btnIncrementarPorcentajeProduccion.setActionCommand("");
		btnIncrementarPorcentajeProduccion.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnIncrementarPorcentajeProduccion.setBackground(Color.GREEN);
		btnIncrementarPorcentajeProduccion.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		JButton btnPasarUnPeriodo = new JButton("Pasar un periodo");
		panel.add(btnPasarUnPeriodo);
		btnPasarUnPeriodo.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnPasarUnPeriodo.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnPasarUnPeriodo.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton btnDecrementarPorcentajeProduccion = new JButton("Decrementa porcentaje produccion");
		panel.add(btnDecrementarPorcentajeProduccion);
		btnDecrementarPorcentajeProduccion.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnDecrementarPorcentajeProduccion.setBackground(Color.RED);
		btnDecrementarPorcentajeProduccion.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
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
		
		txtEmpresa = new JTextField();
		txtEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmpresa.setEditable(false);
		txtEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlEstadoLocal.add(txtEmpresa, "cell 3 5");
		txtEmpresa.setColumns(10);
		
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
		
		txtDemandaAnual = new JTextField();
		txtDemandaAnual.setHorizontalAlignment(SwingConstants.CENTER);
		txtDemandaAnual.setEditable(false);
		txtDemandaAnual.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlEstadoGlobal.add(txtDemandaAnual, "cell 3 3,growx");
		txtDemandaAnual.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Produccion anual");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlEstadoGlobal.add(lblNewLabel_1, "cell 1 5");
		
		txtProduccionAnual = new JTextField();
		txtProduccionAnual.setHorizontalAlignment(SwingConstants.CENTER);
		txtProduccionAnual.setEditable(false);
		txtProduccionAnual.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlEstadoGlobal.add(txtProduccionAnual, "cell 3 5,growx");
		txtProduccionAnual.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Capital Estatal");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlEstadoGlobal.add(lblNewLabel_2, "cell 1 7,alignx trailing,aligny top");
		
		txtCapitalEstatal = new JTextField();
		txtCapitalEstatal.setHorizontalAlignment(SwingConstants.CENTER);
		txtCapitalEstatal.setEditable(false);
		txtCapitalEstatal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlEstadoGlobal.add(txtCapitalEstatal, "cell 3 7,growx");
		txtCapitalEstatal.setColumns(10);
		
		JLabel lblPorcentuales = new JLabel("Porcentuales");
		lblPorcentuales.setFont(new Font("Tahoma", Font.ITALIC, 16));
		pnlEstadoGlobal.add(lblPorcentuales, "cell 0 10");
		
		JLabel lblNewLabel_3 = new JLabel("Crecimiento Anual");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlEstadoGlobal.add(lblNewLabel_3, "cell 1 13,alignx trailing");
		
		txtCrecimientoAnual = new JTextField();
		txtCrecimientoAnual.setHorizontalAlignment(SwingConstants.CENTER);
		txtCrecimientoAnual.setEditable(false);
		txtCrecimientoAnual.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlEstadoGlobal.add(txtCrecimientoAnual, "cell 3 13,growx");
		txtCrecimientoAnual.setColumns(10);
		
		JLabel label_1 = new JLabel(" ");
		pnlEstadoGlobal.add(label_1, "cell 1 17");
		
		txtOcupacion = new JTextField();
		txtOcupacion.setHorizontalAlignment(SwingConstants.CENTER);
		txtOcupacion.setEditable(false);
		txtOcupacion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlEstadoLocal.add(txtOcupacion, "cell 5 5");
		txtOcupacion.setColumns(10);
		comunicadorEstadoGlobal=crearComunicador(pnlEstadoGlobal);
		comunicadorPoblacion=crearComunicador(pnlPoblacion);
		comunicadorEstadoLocal=crearComunicador(pnlEstadoLocal);
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
