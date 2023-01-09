package Model;

public class Admin {

	private int ad_id;
	private String ad_nome;
	private String ad_cpf;
	private String ad_senha;
	private String credencial;
	
	
	
	public int getAd_id() {
		return ad_id;
	}
	public void setAd_id(int ad_id) {
		this.ad_id = ad_id;
	}
	public String getAd_nome() {
		return ad_nome;
	}
	public void setAd_nome(String ad_nome) {
		this.ad_nome = ad_nome;
	}
	public String getAd_cpf() {
		return ad_cpf;
	}
	public void setAd_cpf(String ad_cpf) {
		this.ad_cpf = ad_cpf;
	}
	public String getAd_senha() {
		return ad_senha;
	}
	public void setAd_senha(String ad_senha) {
		this.ad_senha = ad_senha;
	}
	public String getCredencial() {
		return credencial;
	}
	public void setCredencial(String credencial) {
		this.credencial = credencial;
	}
	
	public Admin(int ad_id, String ad_nome, String ad_cpf, String ad_senha, String credencial) {
		super();
		this.ad_id = ad_id;
		this.ad_nome = ad_nome;
		this.ad_cpf = ad_cpf;
		this.ad_senha = ad_senha;
		this.credencial = credencial;
	}
	public Admin() {
		super();
	}
	

	
	
}
