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
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;
import java.awt.Dimension;
import javax.swing.border.CompoundBorder;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
//	private JTextField txtPorcentaje;

	protected Comunicador comunicadorPoblacion, comunicadorEstadoLocal, comunicadorEstadoGlobal;
	private JPanel pnlPoblacion;
	private JPanel pnlEstadoLocal;
	private JPanel pnlEstadoGlobal;
	private JTextField txtDesempleados;
	protected JTextField txtPorcentaje;
	protected JButton btnPasarUnPeriodo;
	protected JButton btnIncrementarPorcentajeProduccion;
	protected JButton btnDecrementarPorcentajeProduccion;

	/**
	 * Create the frame.
	 */
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1340, 722);
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(5, 5));
		contentPane.setBackground(new Color(0, 153, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][grow]", "[][][grow][grow][]"));
		
				JLabel lblPicoli = new JLabel("PICOLI");
				lblPicoli.setForeground(SystemColor.inactiveCaptionBorder);
				lblPicoli.setHorizontalAlignment(SwingConstants.CENTER);
				lblPicoli.setFont(new Font("Sylfaen", Font.BOLD, 50));
				contentPane.add(lblPicoli, "cell 0 0,alignx left");

		pnlPoblacion = new JPanel();
		pnlPoblacion.setBackground(new Color(153, 204, 102));
		contentPane.add(pnlPoblacion, "cell 0 2,grow");
		pnlPoblacion.setLayout(new MigLayout("", "[][][][][grow]", "[][][][][][][][][][][][][][][][][][][][][][][][]"));

		JLabel lblPoblacion = new JLabel("POBLACION");
		lblPoblacion.setForeground(new Color(153, 51, 0));
		lblPoblacion.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnlPoblacion.add(lblPoblacion, "cell 0 0");

		JLabel lblAbsolutos = new JLabel("Absolutos");
		lblAbsolutos.setFont(new Font("Tahoma", Font.ITALIC, 16));
		pnlPoblacion.add(lblAbsolutos, "cell 0 2");

		JLabel lblHabitantes = new JLabel("Habitantes");
		lblHabitantes.setFont(new Font("Tahoma", Font.BOLD, 16));
		pnlPoblacion.add(lblHabitantes, "cell 1 3,alignx trailing");

		txtHabitantes = new JTextField();
		txtHabitantes.setHorizontalAlignment(SwingConstants.CENTER);
		txtHabitantes.setEditable(false);
		txtHabitantes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(txtHabitantes, "cell 4 3");
		txtHabitantes.setColumns(10);

		JLabel lblMenores = new JLabel("Menores");
		lblMenores.setFont(new Font("Tahoma", Font.BOLD, 16));
		pnlPoblacion.add(lblMenores, "cell 1 5,alignx trailing");

		txtMenores = new JTextField();
		txtMenores.setHorizontalAlignment(SwingConstants.CENTER);
		txtMenores.setEditable(false);
		txtMenores.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(txtMenores, "cell 4 5");
		txtMenores.setColumns(10);

		JLabel lblTrabjadores = new JLabel("Trabajadores");
		lblTrabjadores.setFont(new Font("Tahoma", Font.BOLD, 16));
		pnlPoblacion.add(lblTrabjadores, "cell 1 7,alignx trailing");

		txtTrabajadores = new JTextField();
		txtTrabajadores.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrabajadores.setEditable(false);
		txtTrabajadores.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(txtTrabajadores, "cell 4 7");
		txtTrabajadores.setColumns(10);

		JLabel lblJubilados = new JLabel("Jubilados");
		lblJubilados.setFont(new Font("Tahoma", Font.BOLD, 16));
		pnlPoblacion.add(lblJubilados, "cell 1 9,alignx trailing");

		txtJubilados = new JTextField();
		txtJubilados.setHorizontalAlignment(SwingConstants.CENTER);
		txtJubilados.setEditable(false);
		txtJubilados.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(txtJubilados, "cell 4 9");
		txtJubilados.setColumns(10);

		JLabel lblDesempleado = new JLabel("Desempleados");
		lblDesempleado.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesempleado.setFont(new Font("Tahoma", Font.BOLD, 16));
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

		JLabel lblNacimientos = new JLabel("Nacimientos");
		lblNacimientos.setFont(new Font("Tahoma", Font.BOLD, 16));
		pnlPoblacion.add(lblNacimientos, "cell 1 16,alignx trailing");

		txtNacimientos = new JTextField();
		txtNacimientos.setHorizontalAlignment(SwingConstants.CENTER);
		txtNacimientos.setEditable(false);
		txtNacimientos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(txtNacimientos, "cell 4 16");
		txtNacimientos.setColumns(10);

		JLabel lblFallecimientos = new JLabel("Fallecimientos");
		lblFallecimientos.setFont(new Font("Tahoma", Font.BOLD, 16));
		pnlPoblacion.add(lblFallecimientos, "cell 1 18,alignx trailing");

		txtFallecimientos = new JTextField();
		txtFallecimientos.setHorizontalAlignment(SwingConstants.CENTER);
		txtFallecimientos.setEditable(false);
		txtFallecimientos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(txtFallecimientos, "cell 4 18");
		txtFallecimientos.setColumns(10);

		JLabel lblJubilaciones = new JLabel("Jubilaciones");
		lblJubilaciones.setFont(new Font("Tahoma", Font.BOLD, 16));
		pnlPoblacion.add(lblJubilaciones, "cell 1 20,alignx trailing");

		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setEditable(false);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlPoblacion.add(textField_6, "cell 4 20");
		textField_6.setColumns(10);

		JLabel lblNuevosTrabjadores = new JLabel("Nuevos trabjadores");
		lblNuevosTrabjadores.setFont(new Font("Tahoma", Font.BOLD, 16));
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
		pnlBotonera.setBackground(new Color(153, 204, 102));
		contentPane.add(pnlBotonera, "cell 1 2,grow");
		pnlBotonera.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 102));
		pnlBotonera.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		panel_3.setBackground(new Color(153, 204, 102));
		panel.add(panel_3);
				panel_3.setLayout(null);
		
				JLabel lblControlEstado = new JLabel("CONTROL ESTADO");
				lblControlEstado.setForeground(new Color(153, 51, 0));
				lblControlEstado.setBounds(10, 11, 202, 25);
				lblControlEstado.setHorizontalTextPosition(SwingConstants.LEFT);
				panel_3.add(lblControlEstado);
				lblControlEstado.setBorder(null);
				lblControlEstado.setBackground(new Color(153, 204, 102));
				lblControlEstado.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblControlEstado.setHorizontalAlignment(SwingConstants.LEFT);

		btnIncrementarPorcentajeProduccion = new JButton("Incrementa Porcentaje Produccion");
		
		btnIncrementarPorcentajeProduccion.setForeground(new Color(255, 255, 255));
		panel.add(btnIncrementarPorcentajeProduccion);
		btnIncrementarPorcentajeProduccion.setActionCommand("");
		btnIncrementarPorcentajeProduccion.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnIncrementarPorcentajeProduccion.setBackground(new Color(0, 51, 0));
		btnIncrementarPorcentajeProduccion.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 204, 102));
		panel.add(panel_1);
				panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
				txtPorcentaje = new JTextField();
				txtPorcentaje.setAlignmentY(1.0f);
				txtPorcentaje.setAlignmentX(1.0f);
				txtPorcentaje.setEditable(false);
				panel_1.add(txtPorcentaje);
				txtPorcentaje.setHorizontalAlignment(SwingConstants.CENTER);
				txtPorcentaje.setForeground(new Color(255, 255, 255));
				txtPorcentaje.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				txtPorcentaje.setBackground(new Color(0, 153, 102));
				txtPorcentaje.setFont(new Font("Tahoma", Font.BOLD, 20));
				txtPorcentaje.setColumns(5);
						
						JLabel label_3 = new JLabel("%");
						label_3.setFont(new Font("Tahoma", Font.BOLD, 16));
						panel_1.add(label_3);

		btnPasarUnPeriodo = new JButton("Pasar un periodo");
		
		btnPasarUnPeriodo.setBackground(new Color(255, 255, 255));
		panel.add(btnPasarUnPeriodo);
		btnPasarUnPeriodo.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnPasarUnPeriodo.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnPasarUnPeriodo.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(153, 204, 102));
		panel.add(panel_2);

		btnDecrementarPorcentajeProduccion = new JButton("Decrementa porcentaje produccion");
		
		btnDecrementarPorcentajeProduccion.setForeground(new Color(255, 255, 255));
		panel.add(btnDecrementarPorcentajeProduccion);
		btnDecrementarPorcentajeProduccion.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnDecrementarPorcentajeProduccion.setBackground(new Color(204, 0, 0));
		btnDecrementarPorcentajeProduccion.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		pnlEstadoLocal = new JPanel();
		pnlEstadoLocal.setBackground(new Color(153, 204, 102));
		contentPane.add(pnlEstadoLocal, "cell 0 3,grow");
		pnlEstadoLocal.setLayout(new MigLayout("", "[][][][][][]", "[][][][][][][][][][][][][][][][]"));

		JLabel lblEstadoLocal = new JLabel("ESTADO LOCAL");
		lblEstadoLocal.setForeground(new Color(153, 51, 0));
		lblEstadoLocal.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnlEstadoLocal.add(lblEstadoLocal, "cell 0 0");

		JLabel lblFabricas = new JLabel("Fabricas");
		lblFabricas.setFont(new Font("Tahoma", Font.ITALIC, 16));
		pnlEstadoLocal.add(lblFabricas, "cell 0 2");

		pnlEstadoGlobal = new JPanel();
		pnlEstadoGlobal.setBackground(new Color(153, 204, 102));
		contentPane.add(pnlEstadoGlobal, "cell 1 3,grow");
		pnlEstadoGlobal.setLayout(new MigLayout("", "[][][][]", "[][][][][][][][][][][][][][][][][][][][]"));

		JLabel lblEstadoGlobal = new JLabel("ESTADO GLOBAL");
		lblEstadoGlobal.setForeground(new Color(153, 51, 0));
		lblEstadoGlobal.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnlEstadoGlobal.add(lblEstadoGlobal, "cell 0 0");

		JLabel lblAbsolutas = new JLabel("Absolutas");
		lblAbsolutas.setFont(new Font("Tahoma", Font.ITALIC, 16));
		pnlEstadoGlobal.add(lblAbsolutas, "cell 0 1");

		JLabel lblNewLabel = new JLabel("Demanda Anual");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		pnlEstadoGlobal.add(lblNewLabel, "cell 1 1,alignx trailing,aligny center");

		txtDemandaAnual = new JTextField();
		txtDemandaAnual.setHorizontalAlignment(SwingConstants.CENTER);
		txtDemandaAnual.setEditable(false);
		txtDemandaAnual.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlEstadoGlobal.add(txtDemandaAnual, "cell 3 1,growx");
		txtDemandaAnual.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Produccion anual");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		pnlEstadoGlobal.add(lblNewLabel_1, "cell 1 3");

		txtProduccionAnual = new JTextField();
		txtProduccionAnual.setHorizontalAlignment(SwingConstants.CENTER);
		txtProduccionAnual.setEditable(false);
		txtProduccionAnual.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlEstadoGlobal.add(txtProduccionAnual, "cell 3 3,growx");
		txtProduccionAnual.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Capital Estatal");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		pnlEstadoGlobal.add(lblNewLabel_2, "cell 1 6,alignx trailing,aligny top");

		txtCapitalEstatal = new JTextField();
		txtCapitalEstatal.setHorizontalAlignment(SwingConstants.CENTER);
		txtCapitalEstatal.setEditable(false);
		txtCapitalEstatal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlEstadoGlobal.add(txtCapitalEstatal, "cell 3 6,growx");
		txtCapitalEstatal.setColumns(10);

		JLabel lblPorcentuales = new JLabel("Porcentuales");
		lblPorcentuales.setFont(new Font("Tahoma", Font.ITALIC, 16));
		pnlEstadoGlobal.add(lblPorcentuales, "cell 0 12");

		JLabel lblNewLabel_3 = new JLabel("Crecimiento Anual");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		pnlEstadoGlobal.add(lblNewLabel_3, "cell 1 12,alignx trailing");

		txtCrecimientoAnual = new JTextField();
		txtCrecimientoAnual.setHorizontalAlignment(SwingConstants.CENTER);
		txtCrecimientoAnual.setEditable(false);
		txtCrecimientoAnual.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlEstadoGlobal.add(txtCrecimientoAnual, "cell 3 12,growx");
		txtCrecimientoAnual.setColumns(10);

		JLabel label_1 = new JLabel(" ");
		pnlEstadoGlobal.add(label_1, "cell 1 19");

		JLabel lblGrandes = new JLabel("Grandes");
		lblGrandes.setFont(new Font("Tahoma", Font.BOLD, 16));
		pnlEstadoLocal.add(lblGrandes, "cell 2 2,alignx center");

		JLabel lblOcupacion = new JLabel("% ocupacion");
		lblOcupacion.setFont(new Font("Tahoma", Font.BOLD, 16));
		pnlEstadoLocal.add(lblOcupacion, "cell 5 2");

		txtEmpresa = new JTextField();
		txtEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmpresa.setEditable(false);
		txtEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlEstadoLocal.add(txtEmpresa, "cell 2 4");
		txtEmpresa.setColumns(10);

		txtOcupacion = new JTextField();
		txtOcupacion.setHorizontalAlignment(SwingConstants.CENTER);
		txtOcupacion.setEditable(false);
		txtOcupacion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlEstadoLocal.add(txtOcupacion, "cell 5 4");
		txtOcupacion.setColumns(10);
		
		comunicadorEstadoGlobal = crearComunicador(pnlEstadoGlobal);
		comunicadorPoblacion = crearComunicador(pnlPoblacion);
		comunicadorEstadoLocal = crearComunicador(pnlEstadoLocal);
	}

	private Comunicador crearComunicador(JPanel jPanel) {
		Component[] components = jPanel.getComponents();
		Comunicador retorno = new Comunicador();
		for (int i = 0; i < components.length; i++) {
			if (components[i] instanceof JTextField) {
				retorno.addControl((JTextField) components[i]);
			}
		}
		return retorno;
	}

}
