import java.util.Iterator;
import java.util.List;


public class Contrato {

	private Hospede hospede;
	private List<Servicos> servicos;
	private EstrategiaCobranca e;
	private String formaDePagamento;
	private int periodo;
	private boolean aberto;
	
	public Contrato (List<Servicos> servicos, Hospede hospede, EstrategiaCobranca e, int periodo, String formaDePagamento) throws Exception{
		if (periodo <= 0)
			throw new Exception("Periodo invalido");
		
		if (formaDePagamento.equals("") || formaDePagamento == null)
			throw new Exception("Forma de pagamento invalida");
		
		this.hospede = hospede;
		this.servicos = servicos;
		this.e = e;
		this.formaDePagamento = formaDePagamento;
		this.periodo = periodo;
		
		aberto = true;
	}
	
	public EstrategiaCobranca getEstrategia() {
		return e;
	}

	public void setE(EstrategiaCobranca e) {
		this.e = e;
	}

	public String getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public List<Servicos> getServicos() {
		return servicos;
	}

	public int getPeriodo() {
		return periodo;
	}
	
	public void adicionaServico(Servicos servico) throws Exception{
		if (!(isAberto()))
			throw new Exception("O contrato ja foi fechado");
		
		servicos.add(servico);
	}
	
	public boolean isAberto(){
		return aberto;
	}
	
	public void setStatus(){
		if (isAberto())
			aberto = false;
		else
			aberto = true;
	}
	
	public double calculaValorServicos(){
		double soma = 0;
		Iterator<Servicos> it = servicos.iterator();
		while(it.hasNext()) {
			Servicos umServico = it.next();
			soma += umServico.valor();		
		}
		
		return soma;
	}
	
	public double calculaValorTotal(){
		return calculaValorServicos() * getEstrategia().getFator();
	}
	
	
	public Hospede getHospede(){
		return hospede;
	}
	public int getTelefone() {
		return hospede.getTelefone();
	}
	public String getNome() {
		return hospede.getNome();
	}
	public String getCPF() {
		return hospede.getCPF();
	}
	public String getRG() {
		return hospede.getRG();
	}
	public String getEmail() {
		return hospede.getEmail();
	}
	public String getEndereco() {
		return hospede.getEndereco();
	}
	
	private String mostraStatus(){
		if (isAberto())
			return "ABERTO";
		else
			return "FECHADO";
	}
	
	private String imprimeCadaServicoEspecial(){
		String servicosEspeciais = "-";
		for (int i = 1; i < servicos.size(); i++) {
			servicosEspeciais += "\n\n" + servicos.get(i).toString();
		}
		
		return servicosEspeciais;
	}
	
	public String imprimeFaturaFinal(){
		return hospede.toString() + servicos.get(0).toString()
				+ "\nServicos especiais (pela ordem): " + imprimeCadaServicoEspecial()
				+ "\nValor total dos servicos: " + calculaValorServicos() 
				+ "\n\nValor total da estadia: " + calculaValorTotal()
				+ "\n\nStatus do contrato: " + mostraStatus();
	}
	
	@Override
	public String toString(){
		return hospede.toString() + "\nForma de pagamento: " + getFormaDePagamento()
				+ "\nPeriodo da hospedagem: " + getPeriodo() 
				+ servicos.get(0).toString()
				+ "Status do contrato: " + mostraStatus();
	}
	
	@Override
	public boolean equals(Object obj){
		if (!(obj instanceof Contrato))
			return false;
		
		Contrato c1 = (Contrato) obj;
		
		return getHospede().equals(c1.getHospede()) && isAberto() == c1.isAberto() && calculaValorTotal() == c1.calculaValorTotal();
	}
	
	
}
