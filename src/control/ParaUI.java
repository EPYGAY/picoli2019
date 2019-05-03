package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.control.Estado;
import modelo.vista.Datos;
import modelo.vista.DatosEstadoGlobal;
import modelo.vista.DatosEstadoLocal;
import modelo.vista.DatosPoblacion;
import vista.Comunicador;
import vista.UI;

public class ParaUI extends UI {

	private Estado estado;

	public ParaUI() {
		estado = new Estado();
		getDatosEstado();
		btnPasarUnPeriodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				estado.pasarPeriodo();
				getDatosEstado();
			}
		});
		btnIncrementarPorcentajeProduccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estado.aumentarProduccion(0);
			}
		});
		btnDecrementarPorcentajeProduccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estado.decrementarProduccion();
			}
		});

	}
	
	
	public void getDatosEstado() {
		DatosPoblacion datosPoblacion=getDatosPoblacion();
		DatosEstadoLocal datosEstadoLocal=getDatosEstadoLocal();
		DatosEstadoGlobal datosEstadoGlobal=getDatosEstadoGlbal();
		setDatosEnElInterfazUsuario(datosPoblacion, datosEstadoLocal, datosEstadoGlobal);
	}

	private DatosPoblacion getDatosPoblacion() {
		long habitantes = estado.getPoblacion();
		long menores = estado.getNumeroMenores();
		long trabajadores = estado.getNumeroTrabajadores();
		long jubilados = estado.getNumeroJubilados();
		long desempleados=estado.getNumeroDesempleados();
		long nacimientos = estado.getNumeroNacimientos();
		long fallecimientos = estado.getNumeroFallecimientos();
		long jubilaciones = estado.getNumeroJubilaciones();
		long nuevosTrabajadores = estado.getNumeroContrataciones();
		DatosPoblacion datosPoblacion = new DatosPoblacion(habitantes, menores, trabajadores, jubilados,desempleados, nacimientos,
				fallecimientos, jubilaciones, nuevosTrabajadores);
		return datosPoblacion;
	}

	private DatosEstadoLocal getDatosEstadoLocal() {
		int grandes=estado.getNumeroEmpresa();
		float porcentajeGrandes=estado.getPorcentajeGrandes();
		DatosEstadoLocal datosEstadoLocal= new DatosEstadoLocal(grandes, porcentajeGrandes);
		return datosEstadoLocal;
	}
	private DatosEstadoGlobal getDatosEstadoGlbal() {
		double demanda = estado.getDemanda();
		double produccion= estado.getProduccion();
		double capitalEstatal=estado.getCapitalEstatal();
		double crecimientoAnual=estado.getCrecimientoAnual();
		DatosEstadoGlobal datosEstadoGlobal= new DatosEstadoGlobal(demanda, produccion, capitalEstatal, crecimientoAnual);
	return datosEstadoGlobal;
	}

	public void setDatosEnElInterfazUsuario(DatosPoblacion datosPoblacion, DatosEstadoLocal datosEstadoLocal,
			DatosEstadoGlobal datosEstadoGlobal) {
		rellenarComunicador(comunicadorPoblacion, datosPoblacion);
		rellenarComunicador(comunicadorEstadoLocal, datosEstadoLocal);
		rellenarComunicador(comunicadorEstadoGlobal, datosEstadoGlobal);
	}

	public void rellenarComunicador(Comunicador comunicador, Datos datos) {
		comunicador.asignarValores(datos);
	}
}
