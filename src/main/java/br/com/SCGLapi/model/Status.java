package br.com.SCGLapi.model;

public enum Status {
	A("Ativo"), 
	E("Excluído");
	
	private String status;

	Status(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
}