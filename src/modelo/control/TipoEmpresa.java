package modelo.control;

public enum TipoEmpresa {
	pequeña("100"), mediana("400"), grande("1000");

	private String TipoEmpresa;
	
	private TipoEmpresa(String tipoEmpresa) {
		this.TipoEmpresa= tipoEmpresa;
	}

	public String getTipoEmpresa() {
		return TipoEmpresa;
	}

	public void setTipoEmpresa(String tipoEmpresa) {
		TipoEmpresa = tipoEmpresa;
	}

}
