package modelo.control;

public class SeresVivos {

	public int getAhorro() {
		return ahorro;
	}

	public void setAhorro(int ahorro) {
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

	private String nombre;
	private int identificador, NV = 365, ahorro, edad, edadMax;
	private float salario;
	private TipoSerVivo tipo;

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getEdadMax() {
		return edadMax;
	}

	public void setEdadMax(int edadMax) {
		this.edadMax = edadMax;
	}

	public void calcularSalario() {
		//TODO
	}
	
	public void calcularEdadMax() {
		//TODO
	}
	
	public void calcularAhorros() {
		//TODO
	}

}
