package modelo.control;

import utilesglobal.Utilies;

public class SeresVivos {

	private String nombre;
	private int identificador, NV = 365;
	private float salario, edadMax, ahorro, edad;

	private TipoSerVivo tipo;

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
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

	public void calcularSueldo(float sueldo, float dineroEstado) {
		switch (tipo) {
		case desempleado:
			float NVconsueldo = NV - sueldo;
			this.ahorro -= NVconsueldo;
			ahorroinsuficiente();
			break;
		case jubilado:
			if (this.ahorro > NV / 2) {
				this.ahorro -= NV / 2;
			} else {
				if (dineroEstado > this.NV / 4) {
					dineroEstado -= this.NV / 4;
					this.ahorro -= this.NV / 4;
					ahorroinsuficiente();
				} else {
					this.ahorro += dineroEstado;
					dineroEstado = 0;
					this.ahorro -= this.NV / 2;
					ahorroinsuficiente();
				}
			}
			break;
		case menor:
			if (this.NV > sueldo) {
				// Pierde vida
			}
			break;
		case trabajador:
			if (sueldo >= NV) {
				sueldo -= NV;
				if (sueldo < 0) {
					sueldo = 0;
				}
				float sobra = sueldo / 2;
				this.ahorro += sobra / 2;
				dineroEstado += sobra / 2;
			} else {
				float falta = NV - sueldo;
				if (falta > this.ahorro) {
					dineroEstado -= NV / 2;
					if (falta > this.ahorro + NV/2) {
						this.ahorro += NV / 2;
					}
					this.ahorro -= falta;
				}
				ahorroinsuficiente();
			}
			// si cobra suficiente paga el nv , y lo que le sobra mitad dineroestado y la
			// otra ahorro
			// si no cobra lo suficiente ese ayuda de los ahorrosç
			// si no puede pagar el NV le ayuda el estado

			break;
		default:
			break;
		}
	}

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
		this.ahorro+= dinero;
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

	public TipoSerVivo getTipo() {
		return tipo;
	}

	public void setTipo(TipoSerVivo tipo) {
		this.tipo = tipo;
	}

}
