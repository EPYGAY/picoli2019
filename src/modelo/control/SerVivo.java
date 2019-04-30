package modelo.control;

import java.util.ArrayList;

import control.Estado;
import utilesglobal.Utilies;

public class SerVivo {
	public Estado estado = new Estado();
	private String nombre;
	private static int identificador = 1;
	private float NV = 365f;
	private float salario, edadMax, ahorro, edad;

	ArrayList<SerVivo> seresVivos = new ArrayList<SerVivo>();

	public SerVivo(String nombre, int identificador, float nV, float edadMax, float ahorro, float edad) {
		super();
		this.nombre = nombre;
		this.identificador = identificador;
		NV = nV;

		this.edadMax = edadMax;
		this.ahorro = ahorro;
		this.edad = edad;
	}

	public void rellenarListaGlobal(ArrayList<SerVivo> seresVivos) {
		int trabajadores = 100;
		int menores = 50;
		int jubilados = 30;
		for (int i = 0; i < trabajadores; i++) {
			seresVivos.add(new SerVivo("EPYGAY", getIdentificador(), NV,
					Utilies.obtenerAleatorio(obtenerEdadActual(), 90), 0, obtenerEdadActual()));
		}
		for (int i = 0; i < menores; i++) {
			seresVivos.add(new SerVivo("EPYGAY", getIdentificador(), NV,
					Utilies.obtenerAleatorio(obtenerEdadActual(), 90), 0, obtenerEdadActual()));
		}
		for (int i = 0; i < jubilados; i++) {
			seresVivos.add(new SerVivo("EPYGAY", getIdentificador(), NV / 2,
					Utilies.obtenerAleatorio(obtenerEdadActual(), 90), 0, obtenerEdadActual()));
		}

	}

	public int getIdentificador() {
		return identificador++;
	}

	public int obtenerEdadActual() {
		return 0;

	}

	public float getEdad() {
		return edad;
	}

	public void setEdad(float edad) {
		this.edad = edad;
	}

	public float getEdadMax() {
		return edadMax;
	}

	public void setEdadMax(float edadMax) {
		this.edadMax = edadMax;
	}

	/*
	 * public void calcularSueldo(float sueldo, float dineroEstado) { if (tipo ==
	 * tipo.desempleado) { float NVconsueldo = NV - sueldo; this.ahorro -=
	 * NVconsueldo; ahorroinsuficiente(); } if (tipo == tipo.jubilado) { if
	 * (this.ahorro > NV / 2) { this.ahorro -= NV / 2; } else { if (dineroEstado >
	 * this.NV / 4) { dineroEstado -= this.NV / 4; this.ahorro -= this.NV / 4;
	 * ahorroinsuficiente(); } else { this.ahorro += dineroEstado; dineroEstado = 0;
	 * this.ahorro -= this.NV / 2; ahorroinsuficiente(); } } } if (tipo ==
	 * tipo.menor) { if (this.NV > sueldo) { // Pierde vida } } if (tipo ==
	 * tipo.trabajador) { if (sueldo >= NV) { sueldo -= NV; if (sueldo < 0) { sueldo
	 * = 0; } float sobra = sueldo / 2; this.ahorro += sobra / 2; dineroEstado +=
	 * sobra / 2; } else { float falta = NV - sueldo; if (falta > this.ahorro) {
	 * dineroEstado -= NV / 2; if (falta > this.ahorro + NV / 2) { this.ahorro += NV
	 * / 2; } this.ahorro -= falta; } ahorroinsuficiente(); } } // si cobra
	 * suficiente paga el nv , y lo que le sobra mitad dineroestado y la // otra
	 * ahorro // si no cobra lo suficiente ese ayuda de los ahorrosç // si no puede
	 * pagar el NV le ayuda el estado }
	 */
	private void ahorroinsuficiente() {
		if (this.ahorro < 0) {
			// se reduce la vida
			this.ahorro = 0;
		}
	}

	public void calcularEdadMax() {
		int maxEsperanzanVida = 90;
		this.edadMax = Utilies.obtenerAleatorio(maxEsperanzanVida);
	}

	public void calcularAhorros(float dinero) {
		this.ahorro += dinero;
	}

	public float getAhorro() {
		return ahorro;
	}

	public void setAhorro(float ahorro) {
		this.ahorro = ahorro;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

}
