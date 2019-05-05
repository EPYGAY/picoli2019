package modelo.control;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.junit.jupiter.api.Test;

import utilesglobal.Constantes;
import utilesglobal.Utilies;

public class Estado {

	private long identificadores = 0;

	// menores primeros en nacer primeros en salir
	private LinkedList<SerVivo> listaMenores = new LinkedList<SerVivo>();// FIFO
	// desempleados igual (si su nv baja 5 años consecutivos sube ne la lista)
	private LinkedList<SerVivo> listaDesempleados = new LinkedList<SerVivo>();
	// jubilados depende de la edadmax
	private List<SerVivo> listaJubilados = new ArrayList<>();

	private Stack<Empresa> listaFactorias = new Stack<Empresa>();// LIFO

	public long numeroNacimientos = 0;
	private long numeroFallecimientos = 0;
	private long numeroJubilaciones = 0;
	private long numeroContrataciones = 0;
	private double capitalEstatal = 0, crecimientoAnual = 0, produccionAnterior = 0, porcentajeDemanda = 0;

	public void setPorcentajeDemanda(double porcentajeDemanda) {
		this.porcentajeDemanda = porcentajeDemanda;
	}

	public Estado() {
		capitalEstatal = Constantes.CAPITAL_ESTADO_INICIAL;
		condicionesIniciales();
	}

	public void nacimiento() {
		SerVivo menor = new SerVivo(Utilies.obtenerNombreAleatorio(), identificadores++);
		numeroNacimientos++;
		listaMenores.add(menor);
	}

	public void condicionesIniciales() {
		// Menores
		for (int i = 0; i < Constantes.NUMERO_MENORES_INICIAL; i++) {
			nacimiento();
		}
		// Jubilados
		for (int i = 0; i < Constantes.NUMERO_JUBILADOS_INICIAL; i++) {
			SerVivo jubilado = new SerVivo(Utilies.obtenerNombreAleatorio(), ++identificadores,
					Utilies.obtenerAleatorio(65, 90), Utilies.obtenerAleatorio(3000));
			listaJubilados.add(jubilado);
		}
		// Trabjadores
		Empresa empresa = new Empresa();
		for (int i = 0; i < Constantes.NUMERO_TRABAJADORES_INICIAL; i++) {
			SerVivo trabjador = new SerVivo(Utilies.obtenerNombreAleatorio(), ++identificadores,
					Utilies.obtenerAleatorio(18, 64), Utilies.obtenerAleatorio(1000));
			empresa.anadirTrabajador(trabjador);
		}
		listaFactorias.add(empresa);
	}

	public long getPoblacion() {
		long menores = getNumeroMenores();
		long jubilados = getNumeroJubilados();
		long desempleados = getNumeroDesempleados();
		long trabjadores = getNumeroTrabajadores();
		long poblacion = menores + jubilados + desempleados + trabjadores;
		return poblacion;
	}

	public long getNumeroDesempleados() {
		long desempleados = listaDesempleados.size();
		return desempleados;
	}

	public long getNumeroJubilados() {
		long jubilados = listaJubilados.size();
		return jubilados;
	}

	public long getNumeroMenores() {
		long menores = listaMenores.size();
		return menores;
	}

	public long getNumeroTrabajadores() {
		long trabjadores = 0;
		for (Empresa factoria : listaFactorias) {
			trabjadores += factoria.getNumeroTrabjadores();

		}
		return trabjadores;
	}

	public long getNumeroNacimientos() {
		return numeroNacimientos;
	}

	public long getNumeroFallecimientos() {
		return numeroFallecimientos;
	}

	public long getNumeroJubilaciones() {
		return numeroJubilaciones;
	}

	public long getNumeroContrataciones() {
		return numeroContrataciones;
	}

	public double getCapitalEstatal() {
		return capitalEstatal;
	}

	public double getCrecimientoAnual() {
		long produccionActual = getProduccion();
		crecimientoAnual = produccionActual - produccionAnterior;
		produccionAnterior = produccionActual;
		return crecimientoAnual;
	}

	public double getDemanda() {

		float demanda = 0;
		for (SerVivo serVivo : listaDesempleados) {
			demanda += serVivo.getNecesidadVital();
		}
		for (SerVivo serVivo : listaJubilados) {
			demanda += serVivo.getNecesidadVital();
		}
		for (SerVivo serVivo : listaMenores) {
			demanda += serVivo.getNecesidadVital();
		}

		for (Empresa empresa : listaFactorias) {
			for (SerVivo serVivo : empresa.getTrabjadores()) {
				demanda += serVivo.getNecesidadVital();
			}

		}

		double extra = demanda * (porcentajeDemanda / 100);

		return demanda + extra;
	}

	public int getNumeroEmpresa() {
		return listaFactorias.size();

	}

	public float getPorcentajeGrandes() {
		float porcentaje = 0;
		for (Empresa empresa : listaFactorias) {
			porcentaje += empresa.calcularProductividad();
		}
		porcentaje /= getNumeroEmpresa();
		return porcentaje;
	}

	public long getProduccion() {
		long produccion = 0;
		for (Empresa empresa : listaFactorias) {
			produccion += empresa.getProduccion();
		}

		return produccion;

	}

	public void despedir(long numeroDespidos) {
		Empresa empresa = listaFactorias.peek();
		List<SerVivo> despedidos = new ArrayList<>();
		if (empresa.getNumeroTrabjadores() > numeroDespidos) {
			despedidos.addAll(empresa.despedir(numeroDespidos));
			numeroDespidos = 0;
		} else {
			int numeroPosiblesDespidos = empresa.getNumeroTrabjadores();
			numeroDespidos -= numeroPosiblesDespidos;
			empresa.despedir(numeroPosiblesDespidos);
			listaFactorias.pop();
		}
		annadirDesempleados(despedidos);
		// Recursividad
		if (numeroDespidos > 0) {
			despedir(numeroDespidos);
		}

	}

	public void nacer(long numeroDeNacimientos) {

		for (int i = 0; i < numeroDeNacimientos; i++) {
			nacimiento();
		}
		this.numeroNacimientos = numeroDeNacimientos;

	}

	private void annadirDesempleados(List<SerVivo> despedidos) {
		for (SerVivo serVivo : despedidos) {
			listaDesempleados.push(serVivo);
		}

	}

	public void contratar(long numeroContrataciones) {
		Empresa empresa = listaFactorias.peek();
		for (int i = 0; i < numeroContrataciones; i++) {
			empresa.contratar(listaDesempleados.pop());
		}
	}

	private void jubilarGente() {
		pasarDesempleadosAJubilados();
		pasarTrabajadoresAJubilados();
	}

	public void pasarPeriodo() {
		numeroFallecimientos = 0;
		numeroJubilaciones = 0;
		numeroNacimientos = 0;
		numeroContrataciones = 0;
		pasarAnnosAtodos();
		nacer(getNumeroNacimientos());
		morir();
		jubilarGente();
		pasarMenoresADesempleado();
		pagarPoblacion();
		contratar(getNumeroContrataciones());
		despedir(getNumeroContrataciones());

	}

	private void pasarAnnosAtodos() {
		for (SerVivo serVivo : listaJubilados) {
			serVivo.pasarAnno();
		}
		for (SerVivo serVivo : listaDesempleados) {
			serVivo.pasarAnno();
		}
		for (SerVivo serVivo : listaMenores) {
			serVivo.pasarAnno();
		}
		for (Empresa empresa : listaFactorias) {
			for (SerVivo serVivo : empresa.getTrabjadores()) {
				serVivo.pasarAnno();
			}
		}
	}

	private void pagarPoblacion() {
		double subencionMenor;
		subencionMenor = getCapitalEstatal() / getNumeroMenores();
		for (int i = 0; i < listaMenores.size(); i++) {
			float nvMenor = listaMenores.get(i).getNecesidadVital();
			if (subencionMenor < nvMenor) {
				capitalEstatal = capitalEstatal - nvMenor;
			} else {
				capitalEstatal = capitalEstatal - subencionMenor;
			}
		}
		double subencionDesempleo;
		subencionDesempleo = getCapitalEstatal() / getNumeroDesempleados();
		for (int i = 0; i < listaDesempleados.size(); i++) {
			SerVivo desempleado = listaDesempleados.get(i);
			float nvDesempleado = desempleado.getNecesidadVital();
			if (desempleado.tieneAhorrosSuficientes()) {
				desempleado.setAhorro(nvDesempleado);
			} else {
				capitalEstatal = capitalEstatal - subencionDesempleo;
			}
		}
		double subencionJubilado;
		subencionJubilado = getCapitalEstatal() / getNumeroJubilaciones();
		for (int i = 0; i < listaJubilados.size(); i++) {
			SerVivo jubilado = listaJubilados.get(i);
			float nvJubilado = jubilado.getNecesidadVital() / 2;
			if (jubilado.tieneAhorrosSuficientes()) {
				jubilado.setAhorro(nvJubilado);
			} else {
				capitalEstatal = capitalEstatal - subencionJubilado;
			}
		}
	}

	private void pasarTrabajadoresAJubilados() {
		for (Empresa factoria : listaFactorias) {

			Stack<SerVivo> listaTrabajadores = factoria.trabjadores;

			for (int i = 0; i < listaTrabajadores.size(); i++) {

				SerVivo jubi = listaTrabajadores.get(i);
				if (jubi.getEdad() == Constantes.EDAD_JUBILADO) {
					listaJubilados.add(listaTrabajadores.pop());
					numeroJubilaciones++;

				}
			}
		}
	}

	private void pasarDesempleadosAJubilados() {
		for (int i = 0; i < listaDesempleados.size(); i++) {

			SerVivo jubi = listaDesempleados.get(i);
			if (jubi.getEdad() == Constantes.EDAD_JUBILADO) {
				listaJubilados.add(listaDesempleados.pop());
				numeroJubilaciones++;

			}
		}

	}

	private void pasarMenoresADesempleado() {

		for (int i = 0; i < listaMenores.size(); i++) {

			SerVivo jubi = listaMenores.get(i);
			if (jubi.getEdad() == Constantes.EDAD_ADULTA) {
				listaDesempleados.add(listaMenores.pop());
			}
		}
	}

	public void morir() {
		for (int i = 0; i < listaJubilados.size(); i++) {

			SerVivo jubi = listaJubilados.get(i);
			if (jubi.getEdad() == jubi.getEsperanzaVida()) {
				capitalEstatal = capitalEstatal + jubi.getAhorros();
				listaJubilados.remove(jubi);
				numeroFallecimientos++;
			}
		}

		for (int i = 0; i < listaMenores.size(); i++) {

			SerVivo jubi = listaMenores.get(i);
			if (jubi.getEdad() == jubi.getEsperanzaVida()) {
				listaMenores.remove(jubi);
				numeroFallecimientos++;
			}
		}

		for (int i = 0; i < listaDesempleados.size(); i++) {

			SerVivo jubi = listaDesempleados.get(i);
			if (jubi.getEdad() == jubi.getEsperanzaVida()) {
				capitalEstatal = capitalEstatal + jubi.getAhorros();
				listaDesempleados.remove(jubi);
				numeroFallecimientos++;
			}
		}
		for (Empresa factoria : listaFactorias) {

			Stack<SerVivo> listaTrabajadores = factoria.trabjadores;

			for (int i = 0; i < listaDesempleados.size(); i++) {

				SerVivo jubi = listaDesempleados.get(i);
				if (jubi.getEdad() == jubi.getEsperanzaVida()) {
					capitalEstatal = capitalEstatal + jubi.getAhorros();
					listaTrabajadores.remove(jubi);
					numeroFallecimientos++;

				}
			}
		}
	}

	@Test
	void testCondicionesIniciales() {
		assertEquals(getNumeroMenores(), Constantes.NUMERO_MENORES_INICIAL);
		assertEquals(getNumeroJubilados(), Constantes.NUMERO_JUBILADOS_INICIAL);
		int contador = 0;
		for (Empresa factoria : listaFactorias) {
			contador += factoria.getNumeroTrabjadores();
		}
		assertEquals(contador, Constantes.NUMERO_TRABAJADORES_INICIAL);
	}

}
