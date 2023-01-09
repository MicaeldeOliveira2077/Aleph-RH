package Model;

public class Funcionario {
	private int Fun_id;
	private String Nome;
	private String Data_nasc;
	private String Cpf;
	private String Telefone;
	private String Endereco;
	private String Entrada;
	public int getFun_id() {
		return Fun_id;
	}
	public void setFun_id(int fun_id) {
		Fun_id = fun_id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getData_nasc() {
		return Data_nasc;
	}
	public void setData_nasc(String data_nasc) {
		Data_nasc = data_nasc;
	}
	public String getCpf() {
		return Cpf;
	}
	public void setCpf(String cpf) {
		Cpf = cpf;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	public String getEntrada() {
		return Entrada;
	}
	public void setEntrada(String entrada) {
		Entrada = entrada;
	}
	public Funcionario(int fun_id, String nome, String data_nasc, String cpf, String telefone, String endereco,
			String entrada) {
		super();
		Fun_id = fun_id;
		Nome = nome;
		Data_nasc = data_nasc;
		Cpf = cpf;
		Telefone = telefone;
		Endereco = endereco;
		Entrada = entrada;
	}
	public Funcionario() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	

}
