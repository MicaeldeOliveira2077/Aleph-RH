package Model;

public class Agenda1 {
	
	private int Agd_id;
	private String Data_agd;
	private String Assunto;
	private String Texto;

	
	public int getAgd_id() {
		return Agd_id;
	}
	public void setAgd_id(int agd_id) {
		Agd_id = agd_id;
	}
	public String getData_agd() {
		return Data_agd;
	}
	public void setData_agd(String data_agd) {
		Data_agd = data_agd;
	}
	public String getAssunto() {
		return Assunto;
	}
	public void setAssunto(String assunto) {
		Assunto = assunto;
	}
	public String getTexto() {
		return Texto;
	}
	public void setTexto(String texto) {
		Texto = texto;
	}
	public Agenda1(int agd_id, String data_agd, String assunto, String texto) {
		super();
		Agd_id = agd_id;
		Data_agd = data_agd;
		Assunto = assunto;
		Texto = texto;

	}
	public Agenda1() {
		super();
		// TODO Auto-generated constructor stub
	}
}

