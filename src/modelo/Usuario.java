package modelo;

/** Classe que representa o Usuário, creio que não preciso explicar sobre */
public class Usuario {

	private String idUsuario;
	private String nomeUsuario;
	private String loginUsuario;
	private String senhaUsuario;
	private String cargoUsuario;
	private String valorUsuario;

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String string) {
		this.idUsuario = string;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public String getCargoUsuario() {
		return cargoUsuario;
	}

	public void setCargoUsuario(String cargoUsuario) {
		this.cargoUsuario = cargoUsuario;
	}
	public String getValorUsuario() {
		return valorUsuario;
	}

	public void setValorUsuario(String valorUsuario) {
		this.valorUsuario = valorUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nomeUsuario="
				+ nomeUsuario + ", loginUsuario=" + loginUsuario
				+ ", senhaUsuario=" + senhaUsuario + ", cargoUsuario="
				+ cargoUsuario + "valorUsuario="+ valorUsuario+ "]";
	}



}